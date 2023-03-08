package com.bat.car.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseResultCode {

    @JsonProperty("ok")
    OK("ok"),

    @JsonProperty("error")
    ERROR("error");

    private final String code;
}
