package org.evento.gerenciadordeeventos.service;

import org.evento.gerenciadordeeventos.domain.Administrador;
import org.evento.gerenciadordeeventos.dto.AdminRequestDTO;
import org.evento.gerenciadordeeventos.dto.LoginRequestDTO;
import org.evento.gerenciadordeeventos.dto.LoginResponseDTO;
import org.evento.gerenciadordeeventos.repository.AdministradorRepository;
import org.evento.gerenciadordeeventos.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	
	private final AdministradorRepository administradorRepository;
	private final JwtUtil jwtUtil;
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public AuthService(AdministradorRepository administradorRepository, JwtUtil jwtUtil) {
		this.administradorRepository = administradorRepository;
		this.jwtUtil = jwtUtil;
	}
	
	//Função para registrar o usuário no sistema
	public void register(AdminRequestDTO adminDTO) {
		Administrador administrador = new Administrador();
		administrador.setNome(adminDTO.nome);
		administrador.setEmail(adminDTO.email);
		administrador.setSenha(adminDTO.senha);
		administradorRepository.save(administrador);
	}
	
	//Função confirmar o login do usuário no sistema sempre que ele tentar entrar, o login
	public LoginResponseDTO loginResponseDTO(LoginRequestDTO loginRequestDTO) {
		Administrador administrador = administradorRepository.findByEmail(loginRequestDTO.email)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
		
		if (!passwordEncoder.matches(loginRequestDTO.senha, administrador.getSenha())) {
			throw new RuntimeException ("Credenciais inválidas! Tente novamente.");
		}
		
		String token = jwtUtil.gerarToken(administrador.getEmail());
		return new LoginResponseDTO(token);
	}
}
