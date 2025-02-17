package io.github.arturtarcisio.mscustomers.controller;

import io.github.arturtarcisio.mscustomers.domain.Customer;
import io.github.arturtarcisio.mscustomers.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{cpf}")
    public ResponseEntity<Optional<Customer>> searchCustomer (@RequestParam String cpf) {
        return ResponseEntity.ok(customerService.getByCpf(cpf));
    }
}
