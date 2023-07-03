package com.member.exception;

public class MemberNotFindException extends RuntimeException {
    public MemberNotFindException(String message) {
        super(message);
    }
}
