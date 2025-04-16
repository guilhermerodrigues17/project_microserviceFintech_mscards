package io.github.guilhermerodrigues17.mscards.infra.mqueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.guilhermerodrigues17.mscards.domain.Card;
import io.github.guilhermerodrigues17.mscards.domain.CardIssuanceSolicitationData;
import io.github.guilhermerodrigues17.mscards.domain.ClientCard;
import io.github.guilhermerodrigues17.mscards.infra.repository.CardsRepository;
import io.github.guilhermerodrigues17.mscards.infra.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuanceSubscriber {

    private final CardsRepository cardsRepository;
    private final ClientCardRepository clientCardRepository;

    @RabbitListener(queues = "${mq.queues.card-issuance}")
    public void receiveIssuanceSolicitation(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();
            CardIssuanceSolicitationData data = mapper.readValue(payload, CardIssuanceSolicitationData.class);

            Card card = cardsRepository.findById(data.getCardId()).orElseThrow();
            ClientCard clientCard = new ClientCard();
            clientCard.setCard(card);
            clientCard.setCpf(data.getCpf());
            clientCard.setApprovedCreditLimit(data.getApprovedCreditLimit());

            clientCardRepository.save(clientCard);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
