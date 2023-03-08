package com.bat.car.service.betpool;

import com.bat.car.model.client.request.SetBetRequest;
import com.bat.car.model.enums.CarBrandEnum;
import java.math.BigDecimal;

public interface BetCacheService {
    void setBet(SetBetRequest request);

    BigDecimal getTotalBetBrand(CarBrandEnum request);

    BigDecimal getTotalByAllBrand();
}
