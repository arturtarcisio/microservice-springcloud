package io.github.arturtarcisio.mscards.dto;

import io.github.arturtarcisio.mscards.domain.Card;
import io.github.arturtarcisio.mscards.enums.Flag;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {

    private String name;
    private BigDecimal income;
    private Flag flag;
    private BigDecimal limitCredit;

    public Card toModel() {
        return new Card(limitCredit, flag, income, name);
    }

}
