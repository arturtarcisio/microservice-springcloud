package io.github.arturtarcisio.mscards.controller;

import io.github.arturtarcisio.mscards.domain.CreditCard;
import io.github.arturtarcisio.mscards.domain.CustomerCreditCard;
import io.github.arturtarcisio.mscards.dto.CardSaveRequest;
import io.github.arturtarcisio.mscards.dto.CustomerCreditCardResponse;
import io.github.arturtarcisio.mscards.service.CardService;
import io.github.arturtarcisio.mscards.service.CustomerCreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("cards")
public class CreditCardController {

    private final CardService cardService;
    private final CustomerCreditCardService customerCreditCardService;

    @PostMapping
    public ResponseEntity<Void> save (@RequestBody CardSaveRequest cardSaveRequest) {
        CreditCard creditCard = cardService.save(cardSaveRequest);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("id={id}")
                .buildAndExpand(creditCard.getId())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<CreditCard>> findByIncomeLessThanEqual (@RequestParam("income") BigDecimal income) {
        List<CreditCard> creditCards = cardService.findByIncomeLessThanEqual(income);
        return ResponseEntity.ok(creditCards);
    }

    @GetMapping("/creditCardsByCustomer/{cpf}")
    public ResponseEntity<List<CustomerCreditCardResponse>> getCreditCardsByCustomer (@PathVariable String cpf) {
        List<CustomerCreditCard> creditCards = customerCreditCardService.listOfCreditCardByCpf(cpf);
        var listOfCreditCards = creditCards.stream()
                .map(CustomerCreditCardResponse::fromModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(listOfCreditCards);
    }
}
