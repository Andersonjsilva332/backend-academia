package br.com.e2etreinamento.backend_academia.model;

public record Aluno(
        Long id,
        String nome,
        String email,
        Integer idade,
        String whatsapp
) {

	public Long id() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public Integer idade() {
		return idade;
	}

	public String whatsapp() {
		return whatsapp;
	}
}