package br.com.e2etreinamento.backend_academia.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AlunoRequest(

        @NotBlank(message = "O campo nome é obrigatório")
        String nome,

        @NotBlank(message = "O campo email é obrigatório")
        @Email(message = "O campo email deve ser válido")
        String email,

        @NotNull(message = "O campo idade é obrigatório")
        @Min(value = 1, message = "O campo idade deve ser maior que zero")
        @Max(value = 120, message = "O campo idade deve ser menor ou igual a 120")
        Integer idade,

        @NotBlank(message = "O campo whatsapp é obrigatório")
        @Pattern(regexp = "\\d{10,13}", message = "O campo whatsapp deve conter apenas números, com 10 a 13 dígitos")
        String whatsapp
) {

	public String nome() {
		return nome;
	}

	public String email() {
		return email;
	}

	public Integer idade() {
		return idade;
	}

	public String whatsapp() {
		return whatsapp;
	}
}