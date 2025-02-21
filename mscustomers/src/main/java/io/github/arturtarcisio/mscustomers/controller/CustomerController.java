package io.github.arturtarcisio.mscustomers.controller;

import io.github.arturtarcisio.mscustomers.domain.Customer;
import io.github.arturtarcisio.mscustomers.dto.CustomerSaveRequest;
import io.github.arturtarcisio.mscustomers.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("customers")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String status() {
        log.info("obtendo status do microservice de cliente");
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Customer> save (@RequestBody CustomerSaveRequest request) {
        Customer customer = request.toModel();
        customerService.save(customer);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(customer.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity searchCustomer (@RequestParam String cpf) {
        return customerService.getCustomerByCpf(cpf)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
