package com.karam.librarymanagement.infraestructure.repository.publisher.impl;

import com.karam.librarymanagement.domain.Publisher;
import com.karam.librarymanagement.infraestructure.repository.converter.PublisherEntityConverter;
import com.karam.librarymanagement.infraestructure.repository.exception.EntityNotFoundException;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherJpaRepository;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherRepositoryImpl implements PublisherRepository {

    private PublisherJpaRepository jpaRepository;

    private PublisherEntityConverter converter;

    public PublisherRepositoryImpl(PublisherJpaRepository jpaRepository,
                                   PublisherEntityConverter converter) {
        this.jpaRepository = jpaRepository;
        this.converter = converter;
    }

    @Override
    public Publisher findById(Long id) {
        var publisherEntity = jpaRepository.findById(id);

        if (publisherEntity.isPresent()) {
            return converter.toPublisher(publisherEntity.get());
        }

        throw new EntityNotFoundException("Publisher not found");
    }
}
