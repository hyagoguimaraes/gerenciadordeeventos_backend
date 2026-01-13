package org.evento.gerenciadordeeventos.repository;

import java.util.Optional;

import org.evento.gerenciadordeeventos.domain.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
	Optional<Administrador> findByEmail(String email);
}
