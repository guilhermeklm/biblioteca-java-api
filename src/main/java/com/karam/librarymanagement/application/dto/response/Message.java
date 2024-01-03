package com.karam.librarymanagement.application.dto.response;

public class Message {

    private String key;
    private String value;

    public Message(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
