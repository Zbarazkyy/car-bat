package com.bat.car.model.client.common;

import static com.bat.car.model.constant.ConstantValidationMessage.NOT_BLANC;
import static com.bat.car.model.constant.ConstantValidationMessage.NOT_NULL;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseRequest {
    @JsonProperty("request_ref")
    @NotNull(message = NOT_NULL)
    @NotBlank(message = NOT_BLANC)
    private String requestRef;
}
