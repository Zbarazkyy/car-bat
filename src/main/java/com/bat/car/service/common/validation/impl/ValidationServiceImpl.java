package com.bat.car.service.common.validation.impl;

import com.bat.car.model.client.common.BaseRequest;
import com.bat.car.model.exception.BetServiceException;
import com.bat.car.service.common.validation.ValidationService;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ValidationServiceImpl implements ValidationService {
    private Validator beanFieldsValidator;

    @PostConstruct
    private void init() {
        beanFieldsValidator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <T extends BaseRequest> void validateRequest(@NonNull final T request) {
        List<String> errorList = validateFields(request);
        if (!errorList.isEmpty()) {
            doValidateException(request.getRequestRef(), errorList.toString());
        }
    }

    @Override
    public <T> List<String> validateFields(@NonNull final T object) {
        List<String> errorList = new ArrayList<>();
        Set<ConstraintViolation<T>> violations = beanFieldsValidator.validate(object);

        if (!violations.isEmpty()) {
            Map<String, String> errorMap = new HashMap<>();
            for (ConstraintViolation<T> violation : violations) {
                errorMap.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            errorList.add(errorMap.toString());
        }
        return errorList;
    }

    private void doValidateException(final String requestRef,final String message) {
        throw new BetServiceException(HttpStatus.BAD_REQUEST, requestRef, message, "doValidateException");
    }
}
