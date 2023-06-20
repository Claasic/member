package com.member.exception;

public class NotSamePasswordConfirmException extends RuntimeException {
    public NotSamePasswordConfirmException(String message) {
        super(message);
    }
}
