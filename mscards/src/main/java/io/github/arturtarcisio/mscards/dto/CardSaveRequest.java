package io.github.arturtarcisio.mscards.dto;

import io.github.arturtarcisio.mscards.domain.CreditCard;
import io.github.arturtarcisio.mscards.enums.Flag;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {

    private String name;
    private BigDecimal income;
    private Flag flag;
    private BigDecimal limitCredit;

    public CreditCard toModel() {
        return new CreditCard(limitCredit, flag, income, name);
    }

}
