package com.karam.librarymanagement.application.dto;

public class CreateBookOutputDTO extends OutputDTO {

    private Long isbn;

    public CreateBookOutputDTO(Long isbn) {
        this.isbn = isbn;
    }

    public Long getIsbn() {
        return isbn;
    }
}
