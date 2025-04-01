package io.github.arturtarcisio.mscreditappraiser.exceptions;

import lombok.Getter;

public class ErrorComunicationMicroserviceException extends Exception{

    @Getter
    private Integer status;

    public ErrorComunicationMicroserviceException(String msg, Integer status) {
        super(msg);
        this.status = status;
    }

}
