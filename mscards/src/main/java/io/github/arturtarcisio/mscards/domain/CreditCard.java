package io.github.arturtarcisio.mscards.domain;

import io.github.arturtarcisio.mscards.enums.Flag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal income;
    @Enumerated(EnumType.STRING)
    private Flag flag;
    private BigDecimal limitCredit;

    public CreditCard(BigDecimal limitCredit, Flag flag, BigDecimal income, String name) {
        this.limitCredit = limitCredit;
        this.flag = flag;
        this.income = income;
        this.name = name;
    }
}
