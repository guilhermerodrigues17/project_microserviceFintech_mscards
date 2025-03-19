package io.github.guilhermerodrigues17.mscards.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Brands brand;
    private BigDecimal income;
    private BigDecimal creditLimit;

    public Card(String name, Brands brand, BigDecimal income, BigDecimal creditLimit) {
        this.name = name;
        this.brand = brand;
        this.income = income;
        this.creditLimit = creditLimit;
    }
}
