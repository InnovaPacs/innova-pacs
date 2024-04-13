package com.persist.innovapacs.adapter.in.rest.impl.config;

import com.persist.innovapacs.domain.exception.BusinessException;
import com.persist.innovapacs.domain.exception.EntityConflictException;
import com.persist.innovapacs.domain.exception.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandlerConfig {
    static final String ERROR_HANDLED = "Error handled: ";

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<ErrorResponse> handle(BusinessException ex) {
        log.error(ERROR_HANDLED, ex);
        return ResponseEntity.status(ex.getErrorResponse().getHttpStatus()).body(ex.getErrorResponse());
    }

    @ExceptionHandler({EntityConflictException.class})
    public ResponseEntity<ErrorResponse> handle(EntityConflictException ex) {
        log.error(ERROR_HANDLED, ex);
        return ResponseEntity.status(ex.getErrorResponse().getHttpStatus()).body(ex.getErrorResponse());
    }
}
