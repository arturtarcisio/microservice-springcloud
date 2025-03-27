package io.github.arturtarcisio.mscards.controller;

import io.github.arturtarcisio.mscards.domain.Card;
import io.github.arturtarcisio.mscards.dto.CardSaveRequest;
import io.github.arturtarcisio.mscards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("cards")
public class CardController {

    private final CardService service;

    @PostMapping
    public ResponseEntity<Void> save (@RequestBody CardSaveRequest cardSaveRequest) {
        Card card = service.save(cardSaveRequest);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("id={id}")
                .buildAndExpand(card.getId())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping
    public ResponseEntity<List<Card>> findByIncomeLessThanEqual (@RequestParam("income") BigDecimal income) {
        List<Card> cards = service.findByIncomeLessThanEqual(income);
        return ResponseEntity.ok(cards);
    }

}
