package br.com.e2etreinamento.backend_academia.dto;

import br.com.e2etreinamento.backend_academia.model.Aluno;

public record AlunoResponse(
        Long id,
        String nome,
        String email,
        Integer idade,
        String whatsapp
) {

    public static AlunoResponse fromModel(Aluno aluno) {
        return new AlunoResponse(
                aluno.id(),
                aluno.nome(),
                aluno.email(),
                aluno.idade(),
                aluno.whatsapp()
        );
    }
}