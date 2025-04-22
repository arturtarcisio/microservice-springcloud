package io.github.arturtarcisio.mscreditappraiser.controller;

import io.github.arturtarcisio.mscreditappraiser.dto.*;
import io.github.arturtarcisio.mscreditappraiser.exceptions.DataNotFoundException;
import io.github.arturtarcisio.mscreditappraiser.exceptions.ErrorComunicationMicroserviceException;
import io.github.arturtarcisio.mscreditappraiser.exceptions.ErrorRequestCardException;
import io.github.arturtarcisio.mscreditappraiser.service.CreditAppraiserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity creditRating(@RequestBody DataCreditRatingRequest dataCreditRatingRequest) {
        try {
            CreditRatingResponse creditRatingResponse = creditAppraiserService.
                    creditRating(dataCreditRatingRequest.getCpf(), dataCreditRatingRequest.getIncome());
            return ResponseEntity.ok(creditRatingResponse);
        } catch (DataNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ErrorComunicationMicroserviceException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping("card-issuance")
    public ResponseEntity cardRequest(@RequestBody CardIssuanceRequestData data) {
        try {
            ProtocolRequestCard protocolRequestCard = creditAppraiserService.requestCardIssuance(data);
            return ResponseEntity.ok(protocolRequestCard);
        }catch (ErrorRequestCardException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
