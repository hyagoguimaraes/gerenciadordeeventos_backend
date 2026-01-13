package org.evento.gerenciadordeeventos.repository;

import java.util.List;

import org.evento.gerenciadordeeventos.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long>{
	List<Evento> findByAdministradorId(Long administradorId);
}
