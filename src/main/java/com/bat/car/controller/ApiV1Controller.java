package com.bat.car.controller;


import com.bat.car.model.client.request.SetBetRequest;
import com.bat.car.model.client.request.TotalInfoRequest;
import com.bat.car.model.client.response.TotalInfoResponse;
import com.bat.car.service.bet.BetService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cars/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ApiV1Controller {
    private final BetService betService;

    public ApiV1Controller(BetService betService) {
        this.betService = betService;
    }

    @PostMapping(value = "/bet", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> setBet(@RequestBody SetBetRequest request) {
        betService.setBet(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/total-info", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TotalInfoResponse> totalInfo(@RequestBody TotalInfoRequest request) {
        TotalInfoResponse response = betService.getTotalBet(request);
        return ResponseEntity.ok(response);
    }
}
