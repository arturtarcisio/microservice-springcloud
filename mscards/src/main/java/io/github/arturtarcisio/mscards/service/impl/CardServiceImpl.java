package io.github.arturtarcisio.mscards.service.impl;

import io.github.arturtarcisio.mscards.domain.CreditCard;
import io.github.arturtarcisio.mscards.dto.CardSaveRequest;
import io.github.arturtarcisio.mscards.repository.CreditCardRepository;
import io.github.arturtarcisio.mscards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CreditCardRepository repository;

    @Override
    @Transactional
    public CreditCard save(CardSaveRequest cardSaveRequest) {
        CreditCard creditCard = cardSaveRequest.toModel();
        return repository.save(creditCard);
    }

    @Override
    public List<CreditCard> findByIncomeLessThanEqual(BigDecimal income) {
        return repository.findByIncomeLessThanEqual(income);
    }
}
