package com.bat.car.service.common.converter.impl;

import com.bat.car.model.client.common.BaseResponse;
import com.bat.car.model.enums.ResponseResultCode;
import com.bat.car.service.common.converter.ResponseConverter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ResponseConverterImpl implements ResponseConverter {


    @Override
    public ResponseEntity<BaseResponse> generateResponse(Object data, String requestRef) {
        return buildResponse(data, requestRef);
    }

    @Override
    public ResponseEntity<BaseResponse> generateResponse(String requestRef) {
        return buildResponse(null, requestRef);
    }

    private ResponseEntity<BaseResponse> buildResponse(Object data, String requestRef) {
        return ResponseEntity.ok(
                BaseResponse.builder()
                        .requestRef(requestRef)
                        .result(ResponseResultCode.OK)
                        .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .data(data)
                        .build());
    }

    @Override
    public ResponseEntity<BaseResponse> generateResponseByErrorCode(HttpStatus status, String message, String requestRef) {
        return ResponseEntity
                .status(status)
                .body(BaseResponse.builder()
                        .requestRef(requestRef)
                        .result(ResponseResultCode.ERROR)
                        .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .error(message)
                        .build()
                );
    }
}
