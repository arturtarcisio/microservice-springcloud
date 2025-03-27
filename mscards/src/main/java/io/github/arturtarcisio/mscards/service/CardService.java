package io.github.arturtarcisio.mscards.service;

import io.github.arturtarcisio.mscards.domain.CreditCard;
import io.github.arturtarcisio.mscards.dto.CardSaveRequest;

import java.math.BigDecimal;
import java.util.List;

public interface CardService {

    CreditCard save(CardSaveRequest cardSaveRequest);
    List<CreditCard> findByIncomeLessThanEqual(BigDecimal income);
}
