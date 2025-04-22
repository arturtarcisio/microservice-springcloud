package io.github.arturtarcisio.mscreditappraiser.service;

import io.github.arturtarcisio.mscreditappraiser.dto.CardIssuanceRequestData;
import io.github.arturtarcisio.mscreditappraiser.dto.CreditRatingResponse;
import io.github.arturtarcisio.mscreditappraiser.dto.CustomerStatusCredit;
import io.github.arturtarcisio.mscreditappraiser.dto.ProtocolRequestCard;
import io.github.arturtarcisio.mscreditappraiser.exceptions.DataNotFoundException;
import io.github.arturtarcisio.mscreditappraiser.exceptions.ErrorComunicationMicroserviceException;

import java.math.BigDecimal;

public interface CreditAppraiserService {

    CustomerStatusCredit getClientStatus(String cpf) throws DataNotFoundException, ErrorComunicationMicroserviceException;
    CreditRatingResponse creditRating(String cpf, BigDecimal income) throws DataNotFoundException, ErrorComunicationMicroserviceException;
    ProtocolRequestCard requestCardIssuance(CardIssuanceRequestData data);
}
