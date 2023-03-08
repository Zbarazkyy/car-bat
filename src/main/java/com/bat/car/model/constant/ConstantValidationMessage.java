package com.bat.car.model.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstantValidationMessage {
 public static final String INCORRECT_VALUE = "Incorrect value";
 public static final String NOT_NULL = "The parameter cannot be null";
 public static final String NOT_BLANC = "The parameter cannot be blanc";
}
