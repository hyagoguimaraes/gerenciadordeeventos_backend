package org.evento.gerenciadordeeventos.controller;

import java.util.List;

import org.evento.gerenciadordeeventos.domain.Evento;
import org.evento.gerenciadordeeventos.dto.EventoRequestDTO;
import org.evento.gerenciadordeeventos.service.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	private final EventoService eventoService;
	
	public EventoController(EventoService eventoService) {
		this.eventoService = eventoService;
	}

	@GetMapping
	public List<Evento> listar(@RequestParam Long adminId) {
		return eventoService.listarEventos(adminId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Evento criar(@RequestParam Long adminId, @Valid @RequestBody EventoRequestDTO eventoRequestDTO) {
		return eventoService.criarEvento(eventoRequestDTO, adminId);
	}
	
	@PutMapping("/{id}")
	public Evento atualizar(@PathVariable Long id, @RequestBody EventoRequestDTO eventoRequestDTO) {
		return eventoService.atualizarEvento(id, eventoRequestDTO);
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		eventoService.excluirEvento(id);
	}
}
