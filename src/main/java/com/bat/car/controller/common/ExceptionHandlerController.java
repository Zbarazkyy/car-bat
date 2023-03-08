package com.bat.car.controller.common;

import static com.bat.car.model.constant.LogConstant.ERROR_LOG_2;

import com.bat.car.model.client.common.BaseResponse;
import com.bat.car.model.exception.BetServiceException;
import com.bat.car.service.common.converter.ResponseConverter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class ExceptionHandlerController {

    private final ResponseConverter responseConverter;

    public ExceptionHandlerController(ResponseConverter responseConverter) {
        this.responseConverter = responseConverter;
    }

    @ExceptionHandler(value = BetServiceException.class)
    public ResponseEntity<BaseResponse> handleA24Exception(BetServiceException ex) {
        return responseConverter.generateResponseByErrorCode(ex.getErrorCode(), ex.getMessage(), ex.getRequestRef());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<BaseResponse> handleAll(Exception ex) {
        log.error(ERROR_LOG_2, "handleAll", ex.getMessage(), ex);
        return responseConverter.generateResponseByErrorCode(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), "NO_REF");
    }
}
