package com.bat.car.model.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class BetServiceException extends RuntimeException {
    private final HttpStatus errorCode;
    private final String message;

    public BetServiceException(HttpStatus errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;

    }
}
