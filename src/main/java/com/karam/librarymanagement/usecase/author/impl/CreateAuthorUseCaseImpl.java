package com.karam.librarymanagement.usecase.author.impl;

import com.karam.librarymanagement.application.dto.CreateAuthorInputDTO;
import com.karam.librarymanagement.domain.specification.author.CreateAuthorSpecification;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;
import com.karam.librarymanagement.usecase.author.CreateAuthorUseCase;
import com.karam.librarymanagement.usecase.author.converter.AuthorConverter;

public class CreateAuthorUseCaseImpl implements CreateAuthorUseCase {

    private AuthorRepository repository;

    private AuthorConverter converter;

    private CreateAuthorSpecification specification;

    public CreateAuthorUseCaseImpl(AuthorRepository repository,
                                   AuthorConverter converter,
                                   CreateAuthorSpecification createAuthorSpecification) {
        this.repository = repository;
        this.converter = converter;
        this.specification = createAuthorSpecification;
    }

    @Override
    public Long create(CreateAuthorInputDTO dto) {
        var author = converter.toDomain(dto);

        specification.validate(author);

        return repository.save(author);
    }
}
