package com.karam.librarymanagement.domain.specification.book.rules;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;

import java.util.Objects;

public class BookNameAlreadyExistsEntitySpecification extends EntitySpecification<Book> {

    private BookRepository repository;

    public BookNameAlreadyExistsEntitySpecification(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Book entity) {
        var bookId = repository.findIdByTitle(entity.getTitle());

        if (Objects.nonNull(bookId)) {
            addErrorMessage("Title already exists");
        }
    }
}
