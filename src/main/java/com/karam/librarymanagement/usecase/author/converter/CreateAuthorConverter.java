package com.karam.librarymanagement.usecase.author.converter;

import com.karam.librarymanagement.application.dto.CreateAuthorInputDTO;
import com.karam.librarymanagement.domain.Author;

public class CreateAuthorConverter {

    public Author toAuthor(CreateAuthorInputDTO dto) {
        return new Author.Builder()
                .name(dto.name())
                .country(dto.country())
                .build();
    }
}
