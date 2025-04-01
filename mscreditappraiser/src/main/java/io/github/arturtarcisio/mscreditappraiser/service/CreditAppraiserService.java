package io.github.arturtarcisio.mscreditappraiser.service;

import io.github.arturtarcisio.mscreditappraiser.dto.CustomerStatusCredit;
import io.github.arturtarcisio.mscreditappraiser.exceptions.DataNotFoundException;
import io.github.arturtarcisio.mscreditappraiser.exceptions.ErrorComunicationMicroserviceException;

public interface CreditAppraiserService {

    CustomerStatusCredit getClientStatus(String cpf) throws DataNotFoundException, ErrorComunicationMicroserviceException;
}
