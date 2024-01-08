package com.karam.librarymanagement.domain.specification.book;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;

class BookNotExistsSpecification extends EntitySpecification<Book> {

    private BookRepository repository;

    public BookNotExistsSpecification(Book newBook,
                                      BookRepository repository) {
        super(newBook);
        this.repository = repository;
    }

    @Override
    public void validate() {
        var bookNotExist = !repository.existsById(getDomain().getId());

        if (bookNotExist) {
            addErrorMessage("Book not exist");
        }
    }
}
