package org.evento.gerenciadordeeventos.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AdminRequestDTO {
	public String nome;
	public String email;

	@Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$", message = "A senha deve conter pelo menos uma letra maiúscula, uma minúscula, um número e um caractere especial")
	public String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
