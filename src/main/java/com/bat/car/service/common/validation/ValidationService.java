package com.bat.car.service.common.validation;

import com.bat.car.model.client.common.BaseRequest;
import java.util.List;
import lombok.NonNull;

public interface ValidationService {

    <T extends BaseRequest> void validateRequest(T request);

    <T> List<String> validateFields(@NonNull T object);
}
