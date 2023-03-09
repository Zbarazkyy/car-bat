package com.bat.car.model.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetBetRequest {
    @JsonProperty("car_brand")
    private String carBrand;

    @JsonProperty("amount")
    private double amount;
}
