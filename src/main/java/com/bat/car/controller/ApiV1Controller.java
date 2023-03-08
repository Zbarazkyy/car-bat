package com.bat.car.controller;


import static com.bat.car.model.constant.LogConstant.*;

import com.bat.car.model.client.common.BaseResponse;
import com.bat.car.model.client.request.SetBetRequest;
import com.bat.car.model.client.request.TotalInfoRequest;
import com.bat.car.model.client.response.TotalInfoResponse;
import com.bat.car.model.exception.BetServiceException;
import com.bat.car.service.bet.BetService;
import com.bat.car.service.common.converter.ResponseConverter;
import com.bat.car.utils.JsonUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(value = "/cars/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ApiV1Controller {

    private final ResponseConverter responseConverter;
    private final BetService betService;
    private final JsonUtils jsonUtils;


    public ApiV1Controller(ResponseConverter responseConverter, BetService betService, JsonUtils jsonUtils) {
        this.responseConverter = responseConverter;
        this.betService = betService;
        this.jsonUtils = jsonUtils;
    }

    private static final String METHOD_SET_BET = "setBet";
    private static final String METHOD_TOTAL_INFO = "totalInfo";


    @PostMapping(value = "/bet", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse> setBet(@RequestBody SetBetRequest request) {
        log.info(REQUEST_LOG, request.getRequestRef(), METHOD_SET_BET, jsonUtils.getObjectAsString(request));

        try {
            betService.setBet(request);
            log.info(RESPONSE_LOG, request.getRequestRef(), METHOD_SET_BET);
            return responseConverter.generateResponse(request.getRequestRef());
        } catch (BetServiceException e) {
            log.error(ERROR_LOG_3, request.getRequestRef(), METHOD_SET_BET, e.getMethod(), e);
            throw e;
        } catch (Exception e) {
            log.error(ERROR_LOG_2, request.getRequestRef(), METHOD_SET_BET, e);
            throw new BetServiceException(HttpStatus.INTERNAL_SERVER_ERROR, request.getRequestRef(), e.getMessage(), METHOD_SET_BET);
        }
    }

    @PostMapping(value = "/total-info", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse> totalInfo(@RequestBody TotalInfoRequest request) {
        log.info(REQUEST_LOG, request.getRequestRef(), METHOD_TOTAL_INFO, jsonUtils.getObjectAsString(request));

        try {
            TotalInfoResponse response = betService.getTotalBet(request);

            log.info(RESPONSE_LOG, request.getRequestRef(), METHOD_TOTAL_INFO);
            return responseConverter.generateResponse(response, request.getRequestRef());
        } catch (BetServiceException e) {
            log.error(ERROR_LOG_3, request.getRequestRef(), METHOD_TOTAL_INFO, e.getMethod(), e);
            throw e;
        } catch (Exception e) {
            log.error(ERROR_LOG_2, request.getRequestRef(), METHOD_TOTAL_INFO, e);
            throw new BetServiceException(HttpStatus.INTERNAL_SERVER_ERROR, request.getRequestRef(), e.getMessage(), METHOD_SET_BET);
        }
    }
}
