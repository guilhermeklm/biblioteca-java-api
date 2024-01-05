package com.karam.librarymanagement.application.dto;

public class CreatePublisherOutputDTO extends OutputDTO {

    private Long id;

    public CreatePublisherOutputDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
