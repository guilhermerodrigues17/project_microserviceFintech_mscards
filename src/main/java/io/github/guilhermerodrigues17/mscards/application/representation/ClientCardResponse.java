package io.github.guilhermerodrigues17.mscards.application.representation;

import io.github.guilhermerodrigues17.mscards.domain.ClientCard;

import java.math.BigDecimal;

public record ClientCardResponse(
        String name,
        String brand,
        BigDecimal approvedCreditLimit
) {

    public static ClientCardResponse fromModel(ClientCard model) {
        return new ClientCardResponse(
                model.getCard().getName(),
                model.getCard().getBrand().toString(),
                model.getApprovedCreditLimit()
        );
    }
}
