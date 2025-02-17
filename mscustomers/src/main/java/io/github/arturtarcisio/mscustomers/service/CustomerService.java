package io.github.arturtarcisio.mscustomers.service;

import io.github.arturtarcisio.mscustomers.controller.CustomerController;
import io.github.arturtarcisio.mscustomers.domain.Customer;

import java.util.Optional;

public interface CustomerService {

    Customer save (Customer customer);
    Optional<Customer> getByCpf (String cpf);

}
