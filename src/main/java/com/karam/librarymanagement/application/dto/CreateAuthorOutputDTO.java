package com.karam.librarymanagement.application.dto;

public class CreateAuthorOutputDTO extends OutputDTO {

    private Long id;

    public CreateAuthorOutputDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
