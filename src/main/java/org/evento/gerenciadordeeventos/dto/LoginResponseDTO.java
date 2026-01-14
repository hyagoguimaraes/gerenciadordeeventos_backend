package org.evento.gerenciadordeeventos.dto;

public class LoginResponseDTO {
	public String token;
	public Long id;
	
	public LoginResponseDTO(String token, Long id) {
		this.token = token;
		this.id = id;
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
