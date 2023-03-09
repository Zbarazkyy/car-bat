package com.bat.car.service.betpool;

import com.bat.car.model.client.request.SetBetRequest;
import java.util.Map;

public interface BetCacheService {
    void setBet(SetBetRequest request);

    Map<String, Double> getTotalBetBrand(String request);

    Map<String, Double> getTotalByAllBrand();
}
