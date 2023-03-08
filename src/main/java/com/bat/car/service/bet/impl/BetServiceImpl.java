package com.bat.car.service.bet.impl;

import com.bat.car.model.client.request.SetBetRequest;
import com.bat.car.model.client.request.TotalInfoRequest;
import com.bat.car.model.client.response.TotalInfoResponse;
import com.bat.car.service.bet.BetService;
import com.bat.car.service.betpool.BetCacheService;
import com.bat.car.service.common.validation.ValidationService;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class BetServiceImpl implements BetService {
    private final BetCacheService cacheService;
    private final ValidationService validation;

    public BetServiceImpl(BetCacheService cacheService, ValidationService validation) {
        this.cacheService = cacheService;
        this.validation = validation;
    }

    @Override
    public void setBet(SetBetRequest request) {
        validation.validateRequest(request);
        cacheService.setBet(request);
    }

    @Override
    public TotalInfoResponse getTotalBet(TotalInfoRequest request) {
        if (Objects.isNull(request.getCarBrand())) {
            return TotalInfoResponse.builder()
                    .amount(cacheService.getTotalByAllBrand())
                    .build();
        }
        return TotalInfoResponse.builder()
                .amount(cacheService.getTotalBetBrand(request.getCarBrand()))
                .build();
    }
}
