package com.pb.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author @bkalika
 */
public class ErrorDto {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String error;
    private String message;

    public ErrorDto(HttpStatus status, String error, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
