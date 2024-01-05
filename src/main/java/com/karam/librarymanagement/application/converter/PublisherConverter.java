package com.karam.librarymanagement.application.converter;

import com.karam.librarymanagement.application.dto.CreatePublisherOutputDTO;
import org.springframework.stereotype.Service;

@Service
public class PublisherConverter {

    public CreatePublisherOutputDTO toCreatePublisherOutputDTO(Long publisherId) {
        return new CreatePublisherOutputDTO(publisherId);
    }
}
