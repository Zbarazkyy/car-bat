package com.bat.car.model.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class BetServiceException extends RuntimeException {
    private final HttpStatus errorCode;
    private final String message;
    private final String requestRef;
    private final String method;

    public BetServiceException(HttpStatus errorCode, String requestRef, String message, String method) {
        super(message);
        this.errorCode = errorCode;
        this.requestRef = requestRef;
        this.message = message;
        this.method = method;
    }
}
