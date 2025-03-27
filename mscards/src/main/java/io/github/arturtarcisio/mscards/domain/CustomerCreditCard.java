package io.github.arturtarcisio.mscards.domain;

import io.github.arturtarcisio.mscards.dto.CustomerCreditCardResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class CustomerCreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    @ManyToOne
    @JoinColumn(name = "id_card")
    private CreditCard creditCard;

    private BigDecimal creditLimit;

}
