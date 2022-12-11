package com.pb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author @bkalika
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PaymentException extends ApplicationException{
    public PaymentException(String message, HttpStatus status) {
        super(message, status);
    }
}
