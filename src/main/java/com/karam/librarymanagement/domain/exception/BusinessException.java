package com.karam.librarymanagement.domain.exception;

import java.util.List;

public class BusinessException extends RuntimeException {

    private List<String> messages;
    private int statusCode;

    public BusinessException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public BusinessException(List<String> messages) {
        super(concatenateMessages(messages));
        this.messages = messages;
        this.statusCode = 400;
    }

    private static String concatenateMessages(List<String> messages) {
        StringBuilder resultBuilder = new StringBuilder();
        for (String message : messages) {
            resultBuilder.append(" - ").append(message);
        }
        return resultBuilder.toString();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public List<String> getMessages() {
        return messages;
    }
}
