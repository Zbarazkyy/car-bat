package com.bat.car.service;

import com.bat.car.model.client.request.SetBetRequest;
import com.bat.car.service.betpool.BetCacheService;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BetCacheServiceTest {

    @Autowired
    private BetCacheService cacheService;

    private static final String BMW = "bmw";
    private static final String FERRARI = "ferrari";
    private static final String AUDI = "audi";
    private static final String MERCEDES = "mercedes";

    private static final double AMOUNT_1 = 12.5;
    private static final double AMOUNT_2 = 1333.75;
    private static final double AMOUNT_3 = 36;
    private static final double AMOUNT_4 = 1;

    @Test
    void setBet_correct_ok() {
        cacheService.setBet(new SetBetRequest(BMW, AMOUNT_1));
        Map<String, Double> totalBetBrand = cacheService.getTotalBetBrand(BMW);
        Assertions.assertFalse(totalBetBrand.isEmpty());
    }

    @Test
    void setBet_two_same_brands() {
        Map<String, Double> totalBetBrandInStart = new HashMap<>(cacheService.getTotalBetBrand(BMW));
        cacheService.setBet(new SetBetRequest(BMW, AMOUNT_1));
        cacheService.setBet(new SetBetRequest(BMW, AMOUNT_2));
        Map<String, Double> totalBetBrand = cacheService.getTotalBetBrand(BMW);
        double totalAmount = totalBetBrandInStart.get(BMW) + AMOUNT_1 + AMOUNT_2;
        Assertions.assertEquals(totalAmount, totalBetBrand.get(BMW));
    }

    @Test
    void getAllBrands_ok() {
        Map<String, Double> totalByAllBrandInStart = new HashMap<>(cacheService.getTotalByAllBrand());
        cacheService.setBet(new SetBetRequest(BMW, AMOUNT_1));
        cacheService.setBet(new SetBetRequest(AUDI, AMOUNT_2));
        cacheService.setBet(new SetBetRequest(FERRARI, AMOUNT_3));
        Assertions.assertEquals(
                totalByAllBrandInStart.get(BMW) + AMOUNT_1, cacheService.getTotalByAllBrand().get(BMW));
    }
}