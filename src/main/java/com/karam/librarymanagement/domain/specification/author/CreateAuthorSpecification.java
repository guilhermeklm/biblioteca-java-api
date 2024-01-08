package com.karam.librarymanagement.domain.specification.author;

import com.karam.librarymanagement.domain.Author;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.domain.specification.SpecificationTemplate;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;

import java.util.ArrayList;

public class CreateAuthorSpecification extends SpecificationTemplate<Author> {

    private AuthorRepository repository;

    public CreateAuthorSpecification(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addSpecifications(Author newAuthor) {
        var specifications = new ArrayList<EntitySpecification<Author>>();
        specifications.add(new AuthorAlreadyExistsSpecification(newAuthor, repository));
        this.setEntitySpecifications(specifications);
    }
}
