package com.persist.innovapacs.domain.exception;

import com.persist.innovapacs.domain.exception.model.ErrorCode;
import com.persist.innovapacs.domain.exception.model.HttpStatusCode;

import java.util.Map;

public class HL7GenerateFileException extends HttpErrorException {
    public HL7GenerateFileException(ErrorCode errorCode) {
        super(HttpStatusCode.CONFLICT.getCode(), errorCode);
    }

    public HL7GenerateFileException(ErrorCode errorCode, Map<String, String > fields) {
        super(HttpStatusCode.CONFLICT.getCode(), errorCode, fields);
    }
}
