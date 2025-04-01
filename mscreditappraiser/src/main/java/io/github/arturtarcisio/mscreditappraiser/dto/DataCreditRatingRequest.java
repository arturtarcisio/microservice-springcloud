package io.github.arturtarcisio.mscreditappraiser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataCreditRatingRequest {

    private String cpf;
    private BigDecimal income;

}
