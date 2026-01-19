package org.evento.gerenciadordeeventos.dto;

public class LoginResponseDTO {
	public String nome;
	public String token;
	public Long id;
	
	public LoginResponseDTO(String nome, String token, Long id) {
		this.nome = nome;
		this.token = token;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
