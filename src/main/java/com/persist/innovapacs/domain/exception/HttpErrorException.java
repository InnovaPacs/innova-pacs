package com.persist.innovapacs.domain.exception;

import com.persist.innovapacs.domain.exception.model.ErrorCode;
import com.persist.innovapacs.domain.exception.model.ErrorResponse;
import lombok.Getter;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

@Getter
public abstract class HttpErrorException extends RuntimeException implements Serializable {

    final transient ErrorResponse errorResponse;

    protected HttpErrorException(int httpStatus, ErrorCode errorCode, Map<String, String> fields) {
        this.errorResponse = ErrorResponse.builder()
                .fields(fields)
                .code(errorCode)
                .httpStatus(httpStatus)
                .build();
    }

    protected HttpErrorException(int httpStatus, ErrorCode errorCode) {
        super(errorCode.name());
        this.errorResponse = ErrorResponse.builder()
                .fields(Collections.emptyMap())
                .code(errorCode)
                .httpStatus(httpStatus)
                .build();
    }
}
