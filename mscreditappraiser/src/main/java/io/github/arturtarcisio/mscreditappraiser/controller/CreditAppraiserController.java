package io.github.arturtarcisio.mscreditappraiser.controller;

import io.github.arturtarcisio.mscreditappraiser.dto.CustomerStatusCredit;
import io.github.arturtarcisio.mscreditappraiser.exceptions.DataNotFoundException;
import io.github.arturtarcisio.mscreditappraiser.exceptions.ErrorComunicationMicroserviceException;
import io.github.arturtarcisio.mscreditappraiser.service.CreditAppraiserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credit-appraiser")
@RequiredArgsConstructor
public class CreditAppraiserController {

    private final CreditAppraiserService creditAppraiserService;

    @GetMapping
    public String status(){
        return "It works!";
    }

    @GetMapping("/customers-status/{cpf}")
    public ResponseEntity customerStatusCredit(@PathVariable String cpf) {
        try {
            CustomerStatusCredit customerStatusCredit = creditAppraiserService.getClientStatus(cpf);
            return ResponseEntity.ok(customerStatusCredit);
        } catch (DataNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErrorComunicationMicroserviceException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }
}
