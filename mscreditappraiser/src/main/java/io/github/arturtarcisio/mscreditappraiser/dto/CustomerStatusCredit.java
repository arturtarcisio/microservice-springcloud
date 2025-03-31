package io.github.arturtarcisio.mscreditappraiser.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CustomerStatusCredit {

    private CustomerData customerData;
    private List<CustomerCreditCard> cards;

}
