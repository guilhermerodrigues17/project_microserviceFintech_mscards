package io.github.guilhermerodrigues17.mscards.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "id_card")
    private Card card;
    private BigDecimal creditLimit;
}
