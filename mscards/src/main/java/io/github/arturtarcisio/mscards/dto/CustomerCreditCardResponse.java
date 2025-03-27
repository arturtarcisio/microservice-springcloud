package io.github.arturtarcisio.mscards.dto;

import io.github.arturtarcisio.mscards.domain.CustomerCreditCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreditCardResponse {

    private String name;
    private String flag;
    private BigDecimal limitAvailable;

    public static CustomerCreditCardResponse fromModel(CustomerCreditCard customerCreditCard) {
        return new CustomerCreditCardResponse(
                customerCreditCard.getCreditCard().getName(),
                customerCreditCard.getCreditCard().getFlag().toString(),
                customerCreditCard.getCreditLimit()
        );
    }

}
