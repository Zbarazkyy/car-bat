package com.bat.car.service.common.converter;

import com.bat.car.model.client.common.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ResponseConverter {
    ResponseEntity<BaseResponse> generateResponse(Object data, String requestRef);

    ResponseEntity<BaseResponse> generateResponse(String requestRef);

    ResponseEntity<BaseResponse> generateResponseByErrorCode(HttpStatus status, String message, String requestRef);
}
