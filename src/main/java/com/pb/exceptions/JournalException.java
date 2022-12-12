package com.pb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author @bkalika
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class JournalException extends ApplicationException{
    public JournalException(String message, HttpStatus status) {
        super(message, status);
    }
}
