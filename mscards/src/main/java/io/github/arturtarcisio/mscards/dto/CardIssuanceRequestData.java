package io.github.arturtarcisio.mscards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardIssuanceRequestData {

    private Long creditCardId;
    private String cpf;
    private String address;
    private BigDecimal limitReleased;

}
