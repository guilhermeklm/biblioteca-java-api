package com.karam.librarymanagement.usecase.publisher.converter;

import com.karam.librarymanagement.application.dto.CreatePublisherInputDTO;
import com.karam.librarymanagement.domain.Publisher;
import com.karam.librarymanagement.usecase.Converter;

public class CreatePublisherConverter implements Converter<Publisher, CreatePublisherInputDTO> {

    @Override
    public Publisher convert(CreatePublisherInputDTO dto) {
        return Publisher.createPublisher(dto.name());
    }
}
