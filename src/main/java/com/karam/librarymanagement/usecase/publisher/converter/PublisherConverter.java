package com.karam.librarymanagement.usecase.publisher.converter;

import com.karam.librarymanagement.application.dto.CreatePublisherInputDTO;
import com.karam.librarymanagement.domain.Publisher;
import com.karam.librarymanagement.usecase.Converter;

public class PublisherConverter implements Converter<Publisher, CreatePublisherInputDTO> {

    @Override
    public Publisher toDomain(CreatePublisherInputDTO dto) {
        return Publisher.createPublisher(dto.name());
    }
}
