package com.karam.librarymanagement.domain.specification.book.rules;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;

public class BookNotExistsSpecification extends EntitySpecification<Book> {

    private BookRepository repository;

    public BookNotExistsSpecification(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Book entity) {
        var bookNotExist = !repository.existsById(entity.getId());

        if (bookNotExist) {
            addErrorMessage("Book not exist");
        }
    }
}
