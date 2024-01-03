package com.karam.librarymanagement.application.dto.response;

import java.util.List;

public class ApiErrorResponse extends ApiResponse{

    public List<Message> messages;

    public ApiErrorResponse(int statusCode, LinksResponse link, List<Message> messages) {
        super(statusCode, link);
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
