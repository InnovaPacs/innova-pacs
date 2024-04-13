package com.persist.innovapacs.domain.exception;

import com.persist.innovapacs.domain.exception.model.ErrorCode;
import com.persist.innovapacs.domain.exception.model.HttpStatusCode;

import java.util.Map;

public class HL7SendMessageException extends HttpErrorException {
    public HL7SendMessageException(ErrorCode errorCode) {
        super(HttpStatusCode.CONFLICT.getCode(), errorCode);
    }

    public HL7SendMessageException(ErrorCode errorCode, Map<String, String > fields) {
        super(HttpStatusCode.CONFLICT.getCode(), errorCode, fields);
    }
}
