package io.github.arturtarcisio.mscards.service;

import io.github.arturtarcisio.mscards.domain.Card;
import io.github.arturtarcisio.mscards.dto.CardSaveRequest;

import java.math.BigDecimal;
import java.util.List;

public interface CardService {

    Card save(CardSaveRequest cardSaveRequest);
    List<Card> findByIncomeLessThanEqual(BigDecimal income);
}
