package br.com.rodolfo.email.repositories;

import br.com.rodolfo.email.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}
