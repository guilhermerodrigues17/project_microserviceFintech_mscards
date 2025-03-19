package io.github.guilhermerodrigues17.mscards.application.representation;

import io.github.guilhermerodrigues17.mscards.domain.Brands;
import io.github.guilhermerodrigues17.mscards.domain.Card;

import java.math.BigDecimal;

public record CardRequestRepresentation(
        String name,
        Brands brand,
        BigDecimal income,
        BigDecimal creditLimit
) {

    public Card toModel() {
        return new Card(name, brand, income, creditLimit);
    }
}
