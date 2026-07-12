package br.com.e2etreinamento.backend_academia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.e2etreinamento.backend_academia.dto.AlunoRequest;
import br.com.e2etreinamento.backend_academia.dto.AlunoResponse;
import br.com.e2etreinamento.backend_academia.model.Aluno;
import br.com.e2etreinamento.backend_academia.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> cadastrar(@RequestBody @Valid AlunoRequest request) {
        Aluno aluno = alunoService.cadastrar(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(AlunoResponse.fromModel(aluno));
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> listarTodos() {
        List<AlunoResponse> alunos = alunoService.listarTodos()
                .stream()
                .map(AlunoResponse::fromModel)
                .toList();

        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> consultarPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.consultarPorId(id);

        return ResponseEntity.ok(AlunoResponse.fromModel(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid AlunoRequest request
    ) {
        Aluno aluno = alunoService.atualizar(id, request);

        return ResponseEntity.ok(AlunoResponse.fromModel(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}