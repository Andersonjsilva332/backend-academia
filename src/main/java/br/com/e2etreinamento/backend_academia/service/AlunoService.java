package br.com.e2etreinamento.backend_academia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.e2etreinamento.backend_academia.dto.AlunoRequest;
import br.com.e2etreinamento.backend_academia.exception.BusinessException;
import br.com.e2etreinamento.backend_academia.model.Aluno;

@Service
public class AlunoService {

    private final ConcurrentHashMap<Long, Aluno> alunos = new ConcurrentHashMap<>();
    private final AtomicLong geradorId = new AtomicLong(1);

    public Aluno cadastrar(AlunoRequest request) {
        validarEmailDuplicado(request.email(), null);

        Long id = geradorId.getAndIncrement();

        Aluno aluno = new Aluno(
                id,
                request.nome(),
                request.email(),
                request.idade(),
                request.whatsapp()
        );

        alunos.put(id, aluno);

        return aluno;
    }

    public List<Aluno> listarTodos() {
        return new ArrayList<>(alunos.values());
    }

    public Aluno consultarPorId(Long id) {
        Aluno aluno = alunos.get(id);

        if (aluno == null) {
        	throw new BusinessException("Aluno não encontrado com o ID: " + id);
        }

        return aluno;
    }

    public Aluno atualizar(Long id, AlunoRequest request) {
        consultarPorId(id);

        validarEmailDuplicado(request.email(), id);

        Aluno alunoAtualizado = new Aluno(
                id,
                request.nome(),
                request.email(),
                request.idade(),
                request.whatsapp()
        );

        alunos.put(id, alunoAtualizado);

        return alunoAtualizado;
    }

    public void deletar(Long id) {
        Aluno aluno = alunos.remove(id);

        if (aluno == null) {
        	throw new BusinessException("Aluno não encontrado com o ID: " + id);
        }
    }

    private void validarEmailDuplicado(String email, Long idAtual) {
        boolean emailJaExiste = alunos.values()
                .stream()
                .anyMatch(aluno ->
                        aluno.email().equalsIgnoreCase(email)
                                && !aluno.id().equals(idAtual)
                );

        if (emailJaExiste) {
            throw new IllegalArgumentException("Já existe aluno cadastrado com este email");
        }
    }
}