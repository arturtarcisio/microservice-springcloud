package io.github.arturtarcisio.mscreditappraiser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credit-appraiser")
public class CreditAppraiserController {

    @GetMapping
    public String status(){
        return "It works!";
    }
}
