package com.persist.innovapacs.domain.exception.model;

import lombok.Getter;

@Getter
public enum HttpStatusCode {
    // 1xx Informational
    CONTINUE(100, "Continue", "The server has received the request headers..."),
    SWITCHING_PROTOCOLS(101, "Switching Protocols", "The server is switching protocols..."),
    PROCESSING(102, "Processing", "The server has received and is processing the request..."),

    // 2xx Success
    OK(200, "OK", "The request has succeeded..."),
    CREATED(201, "Created", "The request has been fulfilled..."),
    ACCEPTED(202, "Accepted", "The request has been accepted for processing..."),
    // Add more codes here...

    // 3xx Redirection
    MULTIPLE_CHOICES(300, "Multiple Choices", "The requested resource corresponds to any one..."),
    MOVED_PERMANENTLY(301, "Moved Permanently", "The requested resource has been assigned a new..."),
    FOUND(302, "Found", "The requested resource resides temporarily under..."),

    // 4xx Client Error
    BAD_REQUEST(400, "Bad Request", "The server cannot or will not process the request..."),
    UNAUTHORIZED(401, "Unauthorized", "The request has not been applied because it lacks..."),
    FORBIDDEN(403, "Forbidden", "The server understood the request but refuses to..."),
    NOT_FOUND(404, "Forbidden", "The server understood the request but refuses to..."),
    CONFLICT(409, "Conflict","The requested action cannot be completed"),

    // 5xx Server Error
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", "The server encountered an unexpected condition..."),
    NOT_IMPLEMENTED(501, "Not Implemented", "The server does not support the functionality..."),
    SERVICE_UNAVAILABLE(503, "Service Unavailable", "The server is currently unable to handle...");

    private final int code;
    private final String name;
    private final String description;

    HttpStatusCode(int code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return code + " " + name + " (" + description + ")";
    }
}
