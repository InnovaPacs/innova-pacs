package com.persist.innovapacs.domain.exception;

import com.persist.innovapacs.domain.exception.model.ErrorCode;
import com.persist.innovapacs.domain.exception.model.HttpStatusCode;

import java.util.Map;

public class HL7GenerateMessageException extends HttpErrorException {
    public HL7GenerateMessageException(ErrorCode errorCode) {
        super(HttpStatusCode.CONFLICT.getCode(), errorCode);
    }

    public HL7GenerateMessageException(ErrorCode errorCode, Map<String, String > fields) {
        super(HttpStatusCode.CONFLICT.getCode(), errorCode, fields);
    }
}
