package io.github.arturtarcisio.mscreditappraiser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

    private Long id;
    private String name;
    private String flag;
    private BigDecimal limitCredit;

}
