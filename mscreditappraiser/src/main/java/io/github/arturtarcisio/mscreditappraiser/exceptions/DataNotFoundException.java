package io.github.arturtarcisio.mscreditappraiser.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class DataNotFoundException extends Exception {

    public DataNotFoundException() {
        super("Customer data not found for the CPF provided");
    }
}
