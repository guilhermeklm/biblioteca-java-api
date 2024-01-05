package com.karam.librarymanagement.infraestructure.repository.publisher.impl;

import com.karam.librarymanagement.domain.Publisher;
import com.karam.librarymanagement.infraestructure.converter.PublisherEntityConverter;
import com.karam.librarymanagement.infraestructure.exception.EntityNotFoundException;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherJpaRepository;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
class PublisherRepositoryImpl implements PublisherRepository {

    private PublisherJpaRepository jpaRepository;

    private PublisherEntityConverter converter;

    public PublisherRepositoryImpl(PublisherJpaRepository jpaRepository,
                                   PublisherEntityConverter converter) {
        this.jpaRepository = jpaRepository;
        this.converter = converter;
    }

    @Override
    public Publisher save(Publisher publisher) {
        var publisherEntity = converter.toPublisherEntity(publisher);
        var publisherEntitySaved = jpaRepository.save(publisherEntity);
        return converter.toPublisher(publisherEntitySaved);
    }

    @Override
    public Publisher findById(Long id) {
        var publisherEntity = jpaRepository.findById(id);

        if (publisherEntity.isPresent()) {
            return converter.toPublisher(publisherEntity.get());
        }

        throw new EntityNotFoundException("Publisher not found");
    }

    @Override
    public Long findIdByName(String name) {
        return jpaRepository.findIdByName(name);
    }
}
