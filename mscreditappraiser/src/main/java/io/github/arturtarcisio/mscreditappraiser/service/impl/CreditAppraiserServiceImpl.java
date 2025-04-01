package io.github.arturtarcisio.mscreditappraiser.service.impl;

import io.github.arturtarcisio.mscreditappraiser.dto.CustomerCreditCard;
import io.github.arturtarcisio.mscreditappraiser.dto.CustomerData;
import io.github.arturtarcisio.mscreditappraiser.dto.CustomerStatusCredit;
import io.github.arturtarcisio.mscreditappraiser.infra.clients.CardsResourceClientFeign;
import io.github.arturtarcisio.mscreditappraiser.infra.clients.CustomerResourceClientFeign;
import io.github.arturtarcisio.mscreditappraiser.service.CreditAppraiserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditAppraiserServiceImpl implements CreditAppraiserService {

    private final CustomerResourceClientFeign customerResourceClientFeign;
    private final CardsResourceClientFeign cardsResourceClientFeign;

    @Override
    public CustomerStatusCredit getClientStatus(String cpf) {
        ResponseEntity<CustomerData> customerDataResponse = customerResourceClientFeign.searchCustomer(cpf);
        ResponseEntity<List<CustomerCreditCard>> customerCreditCardResponse = cardsResourceClientFeign.getCreditCardsByCustomer(cpf);

        return CustomerStatusCredit
                .builder()
                .customerData(customerDataResponse.getBody())
                .cards(customerCreditCardResponse.getBody() != null ? customerCreditCardResponse.getBody() : new ArrayList<>())
                .build();

    }
}
