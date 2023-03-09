package com.bat.car.service.bet.impl;

import com.bat.car.model.client.request.SetBetRequest;
import com.bat.car.model.client.request.TotalInfoRequest;
import com.bat.car.model.client.response.TotalInfoResponse;
import com.bat.car.model.exception.BetServiceException;
import com.bat.car.service.bet.BetService;
import com.bat.car.service.betpool.BetCacheService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BetServiceImpl implements BetService {
    private final BetCacheService cacheService;

    public BetServiceImpl(BetCacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public void setBet(SetBetRequest request) {
        if (request == null || request.getAmount() <= 0 || request.getCarBrand() == null) {
            throw new BetServiceException(HttpStatus.BAD_REQUEST, "Incorrect data in request");
        }
        cacheService.setBet(request);
    }

    @Override
    public TotalInfoResponse getTotalBet(TotalInfoRequest request) {
        if (request != null && request.getCarBrand() != null) {
            return new TotalInfoResponse(cacheService.getTotalBetBrand(request.getCarBrand()));
        }
        return new TotalInfoResponse(cacheService.getTotalByAllBrand());
    }
}
