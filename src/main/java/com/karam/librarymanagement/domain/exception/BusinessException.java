package com.karam.librarymanagement.domain.exception;

public class BusinessException extends RuntimeException {

    private int statusCode;

    public BusinessException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
