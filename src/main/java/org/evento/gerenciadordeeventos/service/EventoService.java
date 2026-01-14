package org.evento.gerenciadordeeventos.service;

import java.util.List;

import org.evento.gerenciadordeeventos.domain.Administrador;
import org.evento.gerenciadordeeventos.domain.Evento;
import org.evento.gerenciadordeeventos.dto.EventoRequestDTO;
import org.evento.gerenciadordeeventos.repository.AdministradorRepository;
import org.evento.gerenciadordeeventos.repository.EventoRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EventoService {

	private final EventoRepository eventoRepository;
	private final AdministradorRepository administradorRepository;
	
	public EventoService(EventoRepository eventoRepository, AdministradorRepository administradorRepository) {
		this.eventoRepository = eventoRepository;
		this.administradorRepository = administradorRepository;
	}
	
	@Transactional
	public Evento criarEvento(EventoRequestDTO eventoRequestDTO, Long adminId) {
		Administrador administrador = administradorRepository.findById(adminId).orElseThrow();
		Evento evento = new Evento();
		evento.setNome(eventoRequestDTO.nome);
		evento.setData(eventoRequestDTO.data);
		evento.setCep(eventoRequestDTO.cep);
		evento.setLogradouro(eventoRequestDTO.logradouro);
		evento.setNumero(eventoRequestDTO.numero);
		evento.setBairro(eventoRequestDTO.bairro);
		evento.setCidade(eventoRequestDTO.cidade);
		evento.setUf(eventoRequestDTO.uf);
		evento.setImagem(eventoRequestDTO.imagem);
		evento.setAdministrador(administrador);
		return eventoRepository.save(evento);
	}
	
	@Transactional
	public List<Evento> listarEventos(Long adminId) {
		return eventoRepository.findByAdministradorId(adminId);
	}
	
	public Evento atualizarEvento(Long id, EventoRequestDTO eventoRequestDTO) {
	    Evento evento = eventoRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
	    evento.setNome(eventoRequestDTO.getNome());
	    evento.setData(eventoRequestDTO.getData());
	    evento.setCep(eventoRequestDTO.getCep());
	    evento.setLogradouro(eventoRequestDTO.getLogradouro());
	    evento.setNumero(eventoRequestDTO.getNumero());
	    evento.setBairro(eventoRequestDTO.getBairro());
	    evento.setCidade(eventoRequestDTO.getCidade());
	    evento.setUf(eventoRequestDTO.getUf());
	    evento.setImagem(eventoRequestDTO.getImagem()); 
	    return eventoRepository.save(evento);
	}
	
	public void excluirEvento (Long id) {
		eventoRepository.deleteById(id);
	}
}
