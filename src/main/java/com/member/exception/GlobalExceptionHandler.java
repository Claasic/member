package com.member.exception;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exception) {
        List<FieldError> errorMessages = exception.getFieldErrors().stream()
                .map(error -> new FieldError(error.getField() , error.getDefaultMessage()))
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse("Validated Error", errorMessages);
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @Getter
    static class ErrorResponse {
        private String message;
        private List<FieldError> errors;

        public ErrorResponse(String message, List<FieldError> errors) {
            this.message = message;
            this.errors = errors;
        }
    }

    @Getter
    static class FieldError {
        private String field;
        private String message;

        public FieldError(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }


}
