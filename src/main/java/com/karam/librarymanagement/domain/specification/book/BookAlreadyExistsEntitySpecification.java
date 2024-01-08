package com.karam.librarymanagement.domain.specification.book;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;

import java.util.Objects;

class BookAlreadyExistsEntitySpecification extends EntitySpecification<Book> {

    private BookRepository repository;

    public BookAlreadyExistsEntitySpecification(Book newBook,
                                                BookRepository repository) {
        super(newBook);
        this.repository = repository;
    }

    @Override
    public void validate() {
        var bookId = repository.findIdByBook(getDomain());

        if (Objects.nonNull(bookId)) {
            if (Objects.nonNull(getDomain().getId()) && Objects.equals(bookId, getDomain().getId())) {
                return;
            }
            addErrorMessage("Book already exists");
        }
    }
}
