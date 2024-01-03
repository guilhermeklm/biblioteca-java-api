package com.karam.librarymanagement.application.dto.response;

public class LinksResponse {

    private String href;
    private String method;

    public LinksResponse(String href, String method) {
        this.href = href;
        this.method = method;
    }

    public String getHref() {
        return href;
    }

    public String getMethod() {
        return method;
    }
}
