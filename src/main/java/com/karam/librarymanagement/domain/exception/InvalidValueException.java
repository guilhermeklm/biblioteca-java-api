package com.karam.librarymanagement.domain.exception;

public class InvalidValueException extends BusinessException {
    public InvalidValueException(String message) {
        super(message, 400);
    }
}
