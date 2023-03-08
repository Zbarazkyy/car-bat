package com.bat.car.service.betpool.impl;

import com.bat.car.model.client.request.SetBetRequest;
import com.bat.car.model.enums.CarBrandEnum;
import com.bat.car.service.betpool.BetCacheService;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class BetCacheServiceImpl implements BetCacheService {
    private Map<CarBrandEnum, Map<Long, BigDecimal>> betCache;

    @PostConstruct
    private void init() {
        betCache = new ConcurrentHashMap<>();
        Arrays.stream(CarBrandEnum.values()).forEach(brand -> betCache.put(brand, new ConcurrentHashMap<>()));
    }

    @Override
    public void setBet(SetBetRequest request) {
        if (betCache.containsKey(request.getCarBrand())) {
            Map<Long, BigDecimal> betCacheByBrand = betCache.get(request.getCarBrand());
            if (betCacheByBrand.containsKey(request.getClientId())) {
                BigDecimal totalBetByClient = betCacheByBrand.get(request.getClientId()).add(request.getAmount());
                betCacheByBrand.put(request.getClientId(), totalBetByClient);
                return;
            }
            betCacheByBrand.put(request.getClientId(), request.getAmount());
            betCache.put(request.getCarBrand(), betCacheByBrand);
        }
    }

    @Override
    public BigDecimal getTotalBetBrand(CarBrandEnum request) {
        Map<Long, BigDecimal> betCacheByBrand = betCache.get(request);
        return betCacheByBrand.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal getTotalByAllBrand() {
        BigDecimal sum = BigDecimal.ZERO;
        for (CarBrandEnum value : CarBrandEnum.values()) {
            sum = sum.add(getTotalBetBrand(value));
        }
        return sum;
    }
}
