package com.karam.librarymanagement.infraestructure.converter;

import com.karam.librarymanagement.domain.Publisher;
import com.karam.librarymanagement.infraestructure.entity.PublisherEntity;
import org.springframework.stereotype.Service;

@Service
public class PublisherEntityConverter {

    public Publisher toPublisher(PublisherEntity publisherEntity) {
        return Publisher.createPublisher(publisherEntity.getId(), publisherEntity.getName());
    }

    public PublisherEntity toPublisherEntity(Publisher publisher) {
        return new PublisherEntity(publisher.getId(), publisher.getName());
    }
}
