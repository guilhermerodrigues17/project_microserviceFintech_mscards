package io.github.guilhermerodrigues17.mscards.infra.repository;

import io.github.guilhermerodrigues17.mscards.domain.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientCardRepository extends JpaRepository<ClientCard, UUID> {
    List<ClientCard> findByCpf(String cpf);
}
