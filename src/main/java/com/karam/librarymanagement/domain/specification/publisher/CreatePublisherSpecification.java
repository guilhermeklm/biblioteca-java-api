package com.karam.librarymanagement.domain.specification.publisher;

import com.karam.librarymanagement.domain.Publisher;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.domain.specification.SpecificationTemplate;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;

import java.util.ArrayList;

public class CreatePublisherSpecification extends SpecificationTemplate<Publisher> {

    private PublisherRepository repository;

    public CreatePublisherSpecification(PublisherRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void addSpecifications(Publisher newPublisher) {
        var specifications = new ArrayList<EntitySpecification<Publisher>>();
        specifications.add(new PublisherAlreadyExistsSpecification(newPublisher, repository));
        this.setEntitySpecifications(specifications);
    }
}
