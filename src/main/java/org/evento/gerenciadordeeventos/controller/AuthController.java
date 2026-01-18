package org.evento.gerenciadordeeventos.controller;

import org.evento.gerenciadordeeventos.dto.AdminRequestDTO;
import org.evento.gerenciadordeeventos.dto.LoginRequestDTO;
import org.evento.gerenciadordeeventos.dto.LoginResponseDTO;
import org.evento.gerenciadordeeventos.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final AuthService authService;
	
	public AuthController (AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/register")
	public void register (@Valid @RequestBody AdminRequestDTO adminRequestDTO) {
		authService.register(adminRequestDTO);
	}
	
	@PostMapping("/login")
	public LoginResponseDTO loginResponseDTO(@RequestBody LoginRequestDTO loginRequestDTO) {
		return authService.loginResponseDTO(loginRequestDTO);
	}
}
