package com.member.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(BindingResult errors) {

        System.out.println(errors);
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
