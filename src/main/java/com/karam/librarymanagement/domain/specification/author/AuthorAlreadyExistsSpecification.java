package com.karam.librarymanagement.domain.specification.author;

import com.karam.librarymanagement.domain.Author;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;

import java.util.Objects;

class AuthorAlreadyExistsSpecification extends EntitySpecification<Author> {

    private AuthorRepository repository;

    public AuthorAlreadyExistsSpecification(Author newAuthor,
                                            AuthorRepository repository) {
        super(newAuthor);
        this.repository = repository;
    }

    @Override
    public void validate() {
        var authorId = repository.findIdByAuthor(this.getDomain());

        if (Objects.nonNull(authorId)) {
            addErrorMessage("Author already exists");
        }
    }
}
