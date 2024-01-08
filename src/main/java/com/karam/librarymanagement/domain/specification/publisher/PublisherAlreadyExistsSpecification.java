package com.karam.librarymanagement.domain.specification.publisher;

import com.karam.librarymanagement.domain.Publisher;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;

import java.util.Objects;

class PublisherAlreadyExistsSpecification extends EntitySpecification<Publisher> {

    private PublisherRepository repository;

    public PublisherAlreadyExistsSpecification(Publisher newPublisher,
                                               PublisherRepository repository) {
        super(newPublisher);
        this.repository = repository;
    }

    @Override
    public void validate() {
        var publisherId = repository.findIdByName(getDomain().getName());

        if (Objects.nonNull(publisherId)) {
            addErrorMessage("Publisher already exists");
        }
    }
}
