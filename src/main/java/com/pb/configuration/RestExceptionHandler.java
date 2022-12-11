package com.pb.configuration;

import com.pb.exceptions.ApplicationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pb.dto.ErrorDto;

/**
 * @author @bkalika
 */
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {ApplicationException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(ApplicationException exception) {
        return ResponseEntity
                .status(exception.getStatus())
                .body(new ErrorDto(exception.getStatus(), exception.getMessage(), exception.getLocalizedMessage()));
    }
}
