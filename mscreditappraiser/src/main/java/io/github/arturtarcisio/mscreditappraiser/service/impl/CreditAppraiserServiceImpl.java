package io.github.arturtarcisio.mscreditappraiser.service.impl;

import io.github.arturtarcisio.mscreditappraiser.dto.CustomerStatusCredit;
import io.github.arturtarcisio.mscreditappraiser.service.CreditAppraiserService;
import org.springframework.stereotype.Service;

@Service
public class CreditAppraiserServiceImpl implements CreditAppraiserService {

    @Override
    public CustomerStatusCredit getClientStatus(String cpf) {
        // MSCARD - Customer's card
        // MSCUSTOMER - Customer's Data

        return null;
    }
}
