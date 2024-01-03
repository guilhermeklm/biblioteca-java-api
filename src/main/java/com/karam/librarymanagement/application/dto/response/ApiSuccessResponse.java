package com.karam.librarymanagement.application.dto.response;

import com.karam.librarymanagement.application.dto.OutputDTO;

import java.util.List;

public class ApiSuccessResponse extends ApiResponse{

    public List<Message> messages;
    public OutputDTO data;

    public ApiSuccessResponse(int statusCode, LinksResponse link, List<Message> messages, OutputDTO data) {
        super(statusCode, link);
        this.messages = messages;
        this.data = data;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public OutputDTO getData() {
        return data;
    }
}
