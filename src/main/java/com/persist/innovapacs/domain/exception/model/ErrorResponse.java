package com.persist.innovapacs.domain.exception.model;

import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder
public class ErrorResponse {
	int httpStatus;
	ErrorCode code;
	Map<String, String> fields;
}
