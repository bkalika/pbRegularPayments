package com.pb.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author @bkalika
 */
public class SenderException extends ApplicationException {
    public SenderException(String message, HttpStatus status) {
        super(message, status);
    }
}
