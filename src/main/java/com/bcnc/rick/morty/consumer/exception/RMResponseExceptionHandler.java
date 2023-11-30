package com.bcnc.rick.morty.consumer.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RMResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleUnmanagedExceptions(
            RuntimeException ex, WebRequest request) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = "An error occurred";
        String detail = "An error occurred while processing the request. Please contact support";
        ErrorResponseObject response = new ErrorResponseObject(LocalDateTime.now(), message, detail,
                status.getReasonPhrase(), request.getDescription(false), status.value());
        return handleExceptionInternal(ex, response,
                new HttpHeaders(), status, request);
    }

    @ExceptionHandler(value = { NoRMCharacterFoundException.class })
    protected ResponseEntity<Object> handleNoRMCharacterFoundExceptions(
            RuntimeException ex, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = "No Character found with the given name";
        String detail = "No Character was found with the given name. Please check the request parameters and try again";
        ErrorResponseObject response = new ErrorResponseObject(LocalDateTime.now(), message, detail,
                status.getReasonPhrase(), request.getDescription(false), status.value());
        return handleExceptionInternal(ex, response, new HttpHeaders(), status, request);
    }
}
