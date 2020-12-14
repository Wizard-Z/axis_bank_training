package com.sourabh.demoappservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HotelResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(SomethingNotFoundException.class)
    public ResponseEntity<ExceptionResponse> SomethingNotFound(SomethingNotFoundException exception) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
