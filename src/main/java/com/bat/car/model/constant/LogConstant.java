package com.bat.car.model.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LogConstant {
    public static final String REQUEST_LOG = "{} REQUEST {}: {}";
    public static final String RESPONSE_LOG = "{} RESPONSE {}:";
    public static final String ERROR_LOG_3 = "{} ERROR {}: {} {}";
    public static final String ERROR_LOG_2 = "{} ERROR {}: {}";
}
