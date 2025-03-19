package io.github.guilhermerodrigues17.mscards.application;

import io.github.guilhermerodrigues17.mscards.domain.Card;
import io.github.guilhermerodrigues17.mscards.infra.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsService {

    private final CardsRepository repository;

    @Transactional
    public Card save(Card card) {
        return repository.save(card);
    }

    public List<Card> getCardByIncomeLessThanEqual(Long income) {
        var incomeBigDecimal = BigDecimal.valueOf(income);
        return repository.findByIncomeLessThanEqual(incomeBigDecimal);
    }
}
