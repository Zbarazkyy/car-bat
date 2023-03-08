package com.bat.car.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

@AllArgsConstructor
@Getter
public enum CarBrandEnum {
    FERRARI("ferrari"),
    BMW("bmw"),
    AUDI("audi"),
    MERCEDES("mercede");

    private String brand;

    @JsonCreator
    public static CarBrandEnum getCarBrand(String name) {
        if (StringUtils.hasText(name)) {
            return Arrays.stream(CarBrandEnum.values())
                    .filter(a -> a.getBrand().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }
}
