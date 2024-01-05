package com.karam.librarymanagement.usecase.publisher.impl;

import com.karam.librarymanagement.application.dto.CreatePublisherInputDTO;
import com.karam.librarymanagement.domain.specification.publisher.CreatePublisherSpecification;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;
import com.karam.librarymanagement.usecase.publisher.CreatePublisherUseCase;
import com.karam.librarymanagement.usecase.publisher.converter.PublisherConverter;

public class CreatePublisherUseCaseImpl implements CreatePublisherUseCase {

    private PublisherRepository repository;
    private PublisherConverter converter;
    private CreatePublisherSpecification specification;

    public CreatePublisherUseCaseImpl(PublisherRepository repository,
                                      PublisherConverter converter,
                                      CreatePublisherSpecification specification) {
        this.repository = repository;
        this.converter = converter;
        this.specification = specification;
    }

    @Override
    public Long create(CreatePublisherInputDTO dto) {
        var publisher = converter.toDomain(dto);
        specification.validate(publisher);
        var publisherSaved = repository.save(publisher);
        return publisherSaved.getId();
    }
}
