package io.github.arturtarcisio.mscreditappraiser.infra.clients;

import io.github.arturtarcisio.mscreditappraiser.dto.CustomerData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mscustomers", path = "/customers")
public interface CustomerResourceClientFeign {

    @GetMapping(params = "cpf")
    ResponseEntity<CustomerData> searchCustomer (@RequestParam String cpf) ;

}
