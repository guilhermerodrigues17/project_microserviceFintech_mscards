package io.github.guilhermerodrigues17.mscards.application;

import io.github.guilhermerodrigues17.mscards.application.representation.CardRequestRepresentation;
import io.github.guilhermerodrigues17.mscards.application.representation.ClientCardResponse;
import io.github.guilhermerodrigues17.mscards.domain.Card;
import io.github.guilhermerodrigues17.mscards.domain.ClientCard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardsResource {

    private final CardsService cardsService;
    private final ClientCardService clientCardService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CardRequestRepresentation representation) {
        Card card = representation.toModel();
        cardsService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsByIncome(@RequestParam Long income) {
        List<Card> cardsList = cardsService.getCardByIncomeLessThanEqual(income);
        return ResponseEntity.ok(cardsList);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClientCardResponse>> getCardsByCpf(@RequestParam String cpf) {
        List<ClientCard> clientCardsList = clientCardService.listCardsByCpf(cpf);
        List<ClientCardResponse> result = clientCardsList.stream().map(ClientCardResponse::fromModel).toList();
        return ResponseEntity.ok(result);
    }
}
