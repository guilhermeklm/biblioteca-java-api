package com.karam.librarymanagement.usecase.author.converter;

import com.karam.librarymanagement.application.dto.CreateAuthorInputDTO;
import com.karam.librarymanagement.domain.Author;
import com.karam.librarymanagement.usecase.Converter;

public class AuthorConverter implements Converter<Author, CreateAuthorInputDTO> {

    @Override
    public Author toDomain(CreateAuthorInputDTO dto) {
        return new Author.Builder()
                .name(dto.name())
                .country(dto.country())
                .build();
    }
}
