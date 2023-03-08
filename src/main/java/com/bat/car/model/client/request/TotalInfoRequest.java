package com.bat.car.model.client.request;

import com.bat.car.model.client.common.BaseRequest;
import com.bat.car.model.enums.CarBrandEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TotalInfoRequest extends BaseRequest {
    @JsonProperty("car_brand")
    private CarBrandEnum carBrand;
}
