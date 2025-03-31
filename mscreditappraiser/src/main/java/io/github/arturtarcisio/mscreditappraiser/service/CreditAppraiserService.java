package io.github.arturtarcisio.mscreditappraiser.service;

import io.github.arturtarcisio.mscreditappraiser.dto.CustomerStatusCredit;

public interface CreditAppraiserService {

    CustomerStatusCredit getClientStatus(String cpf);
}
