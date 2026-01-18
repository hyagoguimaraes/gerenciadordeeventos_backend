package org.evento.gerenciadordeeventos.config;

import org.evento.gerenciadordeeventos.domain.Administrador;
import org.evento.gerenciadordeeventos.repository.AdministradorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(
            AdministradorRepository administradorRepository,
            PasswordEncoder passwordEncoder) {
        
        return args -> {
        	String email = "admin@evento.com";

            if (administradorRepository.findByEmail(email).isEmpty()) {

                Administrador admininistrador = new Administrador();
                admininistrador.setNome("Administrador");
                admininistrador.setEmail(email);
                admininistrador.setSenha(passwordEncoder.encode("Admin@123"));

                administradorRepository.save(admininistrador);

                System.out.println("Administrador criado com sucesso");
            }
        };
    }
}