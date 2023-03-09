package com.bat.car.service.betpool.impl;

import com.bat.car.model.client.request.SetBetRequest;
import com.bat.car.model.enums.CarBrandEnum;
import com.bat.car.service.betpool.BetCacheService;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class BetCacheServiceImpl implements BetCacheService {
    private Map<String, Double> betCache;

    public BetCacheServiceImpl() {
        this.betCache = new ConcurrentHashMap<>();
    }

    @PostConstruct
    private void init() {
        Arrays.stream(CarBrandEnum.values())
                .forEach(brand -> betCache.put(brand.getBrand(), Double.valueOf(0)));
    }


    @Override
    public void setBet(SetBetRequest request) {
        if (betCache.containsKey(request.getCarBrand())) {
            Double amount = betCache.get(request.getCarBrand()) + request.getAmount();
            betCache.put(request.getCarBrand(), amount);
            return;
        }
        betCache.put(request.getCarBrand(), request.getAmount());
    }

    @Override
    public Map<String, Double> getTotalBetBrand(String request) {
        return Map.of(request, betCache.get(request));
    }

    @Override
    public Map<String, Double> getTotalByAllBrand() {
        return betCache;
    }
}
