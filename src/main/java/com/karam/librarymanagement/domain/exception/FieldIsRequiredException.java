package com.karam.librarymanagement.domain.exception;

public class FieldIsRequiredException extends BusinessException {

    public FieldIsRequiredException(String message) {
        super(message, 400);
    }
}
