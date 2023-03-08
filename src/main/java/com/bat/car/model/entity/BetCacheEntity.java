package com.bat.car.model.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BetCacheEntity {
    private Long clientId;
    private BigDecimal amount;
}
