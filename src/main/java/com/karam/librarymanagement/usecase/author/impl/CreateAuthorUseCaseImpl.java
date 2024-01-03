package com.karam.librarymanagement.usecase.author.impl;

import com.karam.librarymanagement.application.dto.CreateAuthorInputDTO;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;
import com.karam.librarymanagement.usecase.author.CreateAuthorUseCase;
import com.karam.librarymanagement.usecase.author.converter.CreateAuthorConverter;

public class CreateAuthorUseCaseImpl implements CreateAuthorUseCase {

    private AuthorRepository repository;

    private CreateAuthorConverter converter;

    public CreateAuthorUseCaseImpl(AuthorRepository repository,
                                   CreateAuthorConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Long create(CreateAuthorInputDTO dto) {
        var author = converter.toAuthor(dto);
        return repository.save(author);
    }
}
