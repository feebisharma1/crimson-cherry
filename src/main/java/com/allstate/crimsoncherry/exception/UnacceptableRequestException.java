package com.allstate.crimsoncherry.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UnacceptableRequestException extends RuntimeException {

    public UnacceptableRequestException(String message) {
        super(message);
    }
}

