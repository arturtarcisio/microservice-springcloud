package io.github.arturtarcisio.mscreditappraiser.infra.clients;

import io.github.arturtarcisio.mscreditappraiser.dto.CustomerCreditCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "mscards", path = "/cards")
public interface CardsResourceClientFeign {

    @GetMapping("/creditCardsByCustomer/{cpf}")
    ResponseEntity<List<CustomerCreditCard>> getCreditCardsByCustomer (@PathVariable String cpf);

}
