package io.github.arturtarcisio.mscreditappraiser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerStatusCredit {

    private CustomerData customerData;
    private List<CustomerCreditCard> cards;

}
