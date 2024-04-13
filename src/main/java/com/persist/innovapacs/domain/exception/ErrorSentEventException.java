package com.persist.innovapacs.domain.exception;

import com.persist.innovapacs.domain.exception.model.ErrorCode;
import com.persist.innovapacs.domain.exception.model.HttpStatusCode;

import java.util.Map;

public class ErrorSentEventException extends HttpErrorException {

    public ErrorSentEventException(ErrorCode errorCode) {
        super(HttpStatusCode.BAD_REQUEST.getCode(), errorCode);
    }

    public ErrorSentEventException(ErrorCode errorCode, Map<String, String > fields) {
        super(HttpStatusCode.BAD_REQUEST.getCode(), errorCode, fields);
    }
}
