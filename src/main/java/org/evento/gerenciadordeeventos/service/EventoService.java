package org.evento.gerenciadordeeventos.service;

import java.util.List;

import org.evento.gerenciadordeeventos.domain.Administrador;
import org.evento.gerenciadordeeventos.domain.Evento;
import org.evento.gerenciadordeeventos.dto.EventoRequestDTO;
import org.evento.gerenciadordeeventos.repository.AdministradorRepository;
import org.evento.gerenciadordeeventos.repository.EventoRepository;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

	private final EventoRepository eventoRepository;
	private final AdministradorRepository administradorRepository;
	
	public EventoService(EventoRepository eventoRepository, AdministradorRepository administradorRepository) {
		this.eventoRepository = eventoRepository;
		this.administradorRepository = administradorRepository;
	}
	
	public Evento criarEvento(EventoRequestDTO eventoRequestDTO, Long adminId) {
		Administrador administrador = administradorRepository.findById(adminId).orElseThrow();
		Evento evento = new Evento();
		evento.setNome(eventoRequestDTO.nome);
		evento.setData(eventoRequestDTO.data);
		evento.setLocalizacao(eventoRequestDTO.localizacao);
		evento.setImagem(eventoRequestDTO.imagem);
		evento.setAdministrador(administrador);
		return eventoRepository.save(evento);
	}
	
	public List<Evento> listarEventos(Long adminId) {
		return eventoRepository.findByAdministradorId(adminId);
	}
	
	public Evento atualizarEvento(Long id, EventoRequestDTO eventoRequestDTO) {
		Evento evento = eventoRepository.findById(id).orElseThrow();
		evento.setData(eventoRequestDTO.data);
		evento.setLocalizacao(eventoRequestDTO.localizacao);
		return eventoRepository.save(evento);
	}
	
	public void excluirEvento (Long id) {
		eventoRepository.deleteById(id);
	}
}
