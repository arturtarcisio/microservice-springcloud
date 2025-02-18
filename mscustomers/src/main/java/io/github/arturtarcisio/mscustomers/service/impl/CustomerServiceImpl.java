package io.github.arturtarcisio.mscustomers.service.impl;

import io.github.arturtarcisio.mscustomers.domain.Customer;
import io.github.arturtarcisio.mscustomers.infra.repository.CustomerRepository;
import io.github.arturtarcisio.mscustomers.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }


    public Optional<Customer> getCustomerByCpf(String cpf) {
        return customerRepository.findByCpf(cpf);
    }

}
