package com.bat.car.model.client.request;

import static com.bat.car.model.constant.ConstantValidationMessage.INCORRECT_VALUE;
import static com.bat.car.model.constant.ConstantValidationMessage.NOT_NULL;

import com.bat.car.model.client.common.BaseRequest;
import com.bat.car.model.enums.CarBrandEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SetBetRequest extends BaseRequest {
    @JsonProperty("client_id")
    @NotNull(message = NOT_NULL)
    private Long clientId;

    @JsonProperty("car_brand")
    @NotNull(message = NOT_NULL)
    private CarBrandEnum carBrand;

    @JsonProperty("amount")
    @DecimalMin(value = "0.0", message = INCORRECT_VALUE)
    private BigDecimal amount;
}
