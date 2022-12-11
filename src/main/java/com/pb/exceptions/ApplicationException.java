package com.pb.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author @bkalika
 */
public class ApplicationException extends RuntimeException{
    private final HttpStatus status;

    public ApplicationException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
