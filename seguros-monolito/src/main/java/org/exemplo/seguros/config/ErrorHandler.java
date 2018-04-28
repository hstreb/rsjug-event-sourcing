package org.exemplo.seguros.config;

import org.exemplo.seguros.apolice.ApoliceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(ApoliceNotFoundException.class)
    public ResponseEntity<ErrorResponse> exception(ApoliceNotFoundException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()),HttpStatus.NOT_FOUND);
    }
}

class ErrorResponse {
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}