package com.karam.librarymanagement.domain.specification.publisher.rules;

import com.karam.librarymanagement.domain.Publisher;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;

import java.util.Objects;

public class PublisherAlreadyExistsSpecification extends EntitySpecification<Publisher> {

    private PublisherRepository repository;

    public PublisherAlreadyExistsSpecification(PublisherRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Publisher publisher) {
        var publisherId = repository.findIdByName(publisher.getName());

        if (Objects.nonNull(publisherId)) {
            addErrorMessage("Publisher already exists");
        }
    }
}
