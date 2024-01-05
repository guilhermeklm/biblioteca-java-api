package com.karam.librarymanagement.infraestructure.exception;

public class EntityNotFoundException extends RuntimeException{

    private int statusCode;

    public EntityNotFoundException(String message) {
        super(message);
        this.statusCode = 400;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
