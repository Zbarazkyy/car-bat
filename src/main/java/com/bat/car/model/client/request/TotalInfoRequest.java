package com.bat.car.model.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TotalInfoRequest {
    @JsonProperty("car_brand")
    private String carBrand;
}
