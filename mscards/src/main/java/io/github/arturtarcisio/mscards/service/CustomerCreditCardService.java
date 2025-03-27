package io.github.arturtarcisio.mscards.service;

import io.github.arturtarcisio.mscards.domain.CustomerCreditCard;

import java.util.List;

public interface CustomerCreditCardService {

    List<CustomerCreditCard> listOfCreditCardByCpf (String cpf);

}
