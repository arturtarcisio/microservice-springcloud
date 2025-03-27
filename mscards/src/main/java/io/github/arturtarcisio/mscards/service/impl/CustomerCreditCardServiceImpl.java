package io.github.arturtarcisio.mscards.service.impl;

import io.github.arturtarcisio.mscards.domain.CustomerCreditCard;
import io.github.arturtarcisio.mscards.repository.CustomerCreditCardRepository;
import io.github.arturtarcisio.mscards.service.CustomerCreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerCreditCardServiceImpl implements CustomerCreditCardService {

    private final CustomerCreditCardRepository repository;


    @Override
    public List<CustomerCreditCard> listOfCreditCardByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
