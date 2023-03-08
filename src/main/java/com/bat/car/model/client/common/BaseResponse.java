package com.bat.car.model.client.common;

import com.bat.car.model.enums.ResponseResultCode;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    @JsonProperty("request_ref")
    private String requestRef;

    @JsonProperty("response_ref")
    private String responseRef;

    @JsonProperty("result")
    private ResponseResultCode result;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("data")
    private Object data;

    @JsonProperty("error")
    private String error;
}
