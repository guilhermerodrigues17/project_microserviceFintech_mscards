package io.github.guilhermerodrigues17.mscards.infra.repository;

import io.github.guilhermerodrigues17.mscards.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface CardsRepository extends JpaRepository<Card, UUID> {
    List<Card> findByIncomeLessThanEqual(BigDecimal income);
}
