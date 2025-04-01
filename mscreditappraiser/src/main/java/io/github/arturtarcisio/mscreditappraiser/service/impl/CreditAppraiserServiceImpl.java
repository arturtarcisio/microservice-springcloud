package io.github.arturtarcisio.mscreditappraiser.service.impl;

import io.github.arturtarcisio.mscreditappraiser.dto.CustomerData;
import io.github.arturtarcisio.mscreditappraiser.dto.CustomerStatusCredit;
import io.github.arturtarcisio.mscreditappraiser.infra.clients.CustomerResourceClientFeign;
import io.github.arturtarcisio.mscreditappraiser.service.CreditAppraiserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditAppraiserServiceImpl implements CreditAppraiserService {

    private final CustomerResourceClientFeign customerResourceClientFeign;

    @Override
    public CustomerStatusCredit getClientStatus(String cpf) {
        // MSCARD - Customer's card
        // MSCUSTOMER - Customer's Data

        ResponseEntity<CustomerData> customerDataResponse = customerResourceClientFeign.searchCustomer(cpf);
        return CustomerStatusCredit
                .builder()
                .customerData(customerDataResponse.getBody())
                .build();

    }
}
