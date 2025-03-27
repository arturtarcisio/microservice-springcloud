package io.github.arturtarcisio.mscards.service.impl;

import io.github.arturtarcisio.mscards.domain.Card;
import io.github.arturtarcisio.mscards.dto.CardSaveRequest;
import io.github.arturtarcisio.mscards.repository.CardRepository;
import io.github.arturtarcisio.mscards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository repository;

    @Override
    @Transactional
    public Card save(CardSaveRequest cardSaveRequest) {
        Card card = cardSaveRequest.toModel();
        return repository.save(card);
    }

    @Override
    public List<Card> findByIncomeLessThanEqual(BigDecimal income) {
        return repository.findByIncomeLessThanEqual(income);
    }
}
