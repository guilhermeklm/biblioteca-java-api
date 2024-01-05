package com.karam.librarymanagement.domain.specification.author.rules;

import com.karam.librarymanagement.domain.Author;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;

import java.util.Objects;

public class AuthorAlreadyExistsSpecification extends EntitySpecification<Author> {

    private AuthorRepository repository;

    public AuthorAlreadyExistsSpecification(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Author entity) {
        var authorId = repository.findIdByAuthor(entity);

        if (Objects.nonNull(authorId)) {
            addErrorMessage("Author already exists");
        }
    }
}
