package io.github.arturtarcisio.mscreditappraiser.service.impl;

import feign.FeignException;
import io.github.arturtarcisio.mscreditappraiser.dto.*;
import io.github.arturtarcisio.mscreditappraiser.exceptions.DataNotFoundException;
import io.github.arturtarcisio.mscreditappraiser.exceptions.ErrorComunicationMicroserviceException;
import io.github.arturtarcisio.mscreditappraiser.infra.clients.CardsResourceClientFeign;
import io.github.arturtarcisio.mscreditappraiser.infra.clients.CustomerResourceClientFeign;
import io.github.arturtarcisio.mscreditappraiser.service.CreditAppraiserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditAppraiserServiceImpl implements CreditAppraiserService {

    private final CustomerResourceClientFeign customerResourceClientFeign;
    private final CardsResourceClientFeign cardsResourceClientFeign;

    @Override
    public CustomerStatusCredit getClientStatus(String cpf) throws DataNotFoundException, ErrorComunicationMicroserviceException {
        try {
            ResponseEntity<CustomerData> customerDataResponse = customerResourceClientFeign.searchCustomer(cpf);
            ResponseEntity<List<CustomerCreditCard>> customerCreditCardResponse = cardsResourceClientFeign.getCreditCardsByCustomer(cpf);

            return CustomerStatusCredit
                    .builder()
                    .customerData(customerDataResponse.getBody())
                    .cards(customerCreditCardResponse.getBody() != null ? customerCreditCardResponse.getBody() : new ArrayList<>())
                    .build();
        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new DataNotFoundException();
            }
            throw new ErrorComunicationMicroserviceException(e.getMessage(), status);
        }
    }

    @Override
    public CreditRatingResponse creditRating(String cpf, BigDecimal income) throws DataNotFoundException, ErrorComunicationMicroserviceException {
        try{
            ResponseEntity<CustomerData> customerDataResponse = customerResourceClientFeign.searchCustomer(cpf);
            ResponseEntity<List<CreditCard>> creditCardsResponse = cardsResourceClientFeign.findByIncomeLessThanEqual(income);

            BigDecimal age = new BigDecimal(customerDataResponse.getBody().getAge());
            var factor = age.divide(BigDecimal.valueOf(10));

            List<CreditCard> cards = creditCardsResponse.getBody();

            var creditCardsApproved = cards.stream().map(creditCard -> {
                var limitApproved = factor.multiply(creditCard.getLimitCredit());

                 return CreditCardApproved
                        .builder()
                        .cardName(creditCard.getName())
                        .preApprovedLimit(limitApproved)
                        .flag(creditCard.getFlag())
                        .build();
            }).collect(Collectors.toList());

            return CreditRatingResponse
                    .builder()
                    .creditCardsApproved(creditCardsApproved)
                    .build();

        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new DataNotFoundException();
            }
            throw new ErrorComunicationMicroserviceException(e.getMessage(), status);
        }
    }
}
