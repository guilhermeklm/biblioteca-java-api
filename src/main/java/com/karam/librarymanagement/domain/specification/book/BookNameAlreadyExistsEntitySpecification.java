package com.karam.librarymanagement.domain.specification.book;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;

import java.util.Objects;

class BookNameAlreadyExistsEntitySpecification extends EntitySpecification<Book> {

    private BookRepository repository;

    public BookNameAlreadyExistsEntitySpecification(Book newBook,
                                                    BookRepository repository) {
        super(newBook);
        this.repository = repository;
    }

    @Override
    public void validate() {
        var bookId = repository.findIdByTitle(getDomain().getTitle());

        if (Objects.nonNull(bookId)) {
            addErrorMessage("Title already exists");
        }
    }
}
