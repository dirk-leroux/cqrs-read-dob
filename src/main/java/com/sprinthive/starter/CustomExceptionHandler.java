package com.sprinthive.starter;

import com.sprinthive.starter.cqrs.read.dob.DobNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseMsg CustomerNotFoundException(DobNotFoundException ex) {
        return ResponseMsg.builder().msg(ex.getMessage()).build();
    }
}
