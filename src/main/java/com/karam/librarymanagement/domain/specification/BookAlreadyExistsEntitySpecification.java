package com.karam.librarymanagement.domain.specification;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;

import java.util.Objects;

public class BookAlreadyExistsEntitySpecification extends EntitySpecification<Book> {

    private BookRepository repository;

    public BookAlreadyExistsEntitySpecification(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    void validate(Book entity) {
        var bookId = repository.findIdByBook(entity);

        if (Objects.nonNull(bookId)) {
            addErrorMessage("Book already exists");
        }
    }
}
