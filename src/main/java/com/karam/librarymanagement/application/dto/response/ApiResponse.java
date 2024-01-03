package com.karam.librarymanagement.application.dto.response;

public class ApiResponse {

    public int statusCode;
    public LinksResponse link;

    public ApiResponse(int statusCode, LinksResponse link) {
        this.statusCode = statusCode;
        this.link = link;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public LinksResponse getLink() {
        return link;
    }
}
