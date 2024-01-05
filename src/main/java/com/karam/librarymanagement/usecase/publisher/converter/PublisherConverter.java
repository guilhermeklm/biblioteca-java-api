package com.karam.librarymanagement.usecase.publisher.converter;

import com.karam.librarymanagement.application.dto.CreatePublisherInputDTO;
import com.karam.librarymanagement.domain.Publisher;
import com.karam.librarymanagement.usecase.CreateDomainConverter;

public class PublisherConverter extends CreateDomainConverter<Publisher, CreatePublisherInputDTO> {

    @Override
    public Publisher toDomain(CreatePublisherInputDTO dto) {
        return Publisher.createPublisher(dto.name());
    }
}
