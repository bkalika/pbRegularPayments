package com.pb.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author @bkalika
 */
public class ClientException extends ApplicationException {
    public ClientException(String message, HttpStatus status) {
        super(message, status);
    }
}
