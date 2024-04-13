package com.persist.innovapacs.domain.exception;

import com.persist.innovapacs.domain.exception.model.ErrorCode;
import com.persist.innovapacs.domain.exception.model.HttpStatusCode;

import java.util.Map;

public class RepositoryConflictException extends HttpErrorException {

    public RepositoryConflictException(ErrorCode errorCode) {
        super(HttpStatusCode.BAD_REQUEST.getCode(), errorCode);
    }

    public RepositoryConflictException(ErrorCode errorCode, Map<String, String > fields) {
        super(HttpStatusCode.BAD_REQUEST.getCode(), errorCode, fields);
    }
}
