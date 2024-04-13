package com.persist.innovapacs.domain.exception;

import com.persist.innovapacs.domain.exception.model.ErrorCode;
import com.persist.innovapacs.domain.exception.model.HttpStatusCode;

import java.util.Map;

public class EntityConflictException extends HttpErrorException {

    public EntityConflictException(ErrorCode errorCode) {
        super(HttpStatusCode.BAD_REQUEST.getCode(), errorCode);
    }

    public EntityConflictException(ErrorCode errorCode, Map<String, String > fields) {
        super(HttpStatusCode.BAD_REQUEST.getCode(), errorCode, fields);
    }
}
