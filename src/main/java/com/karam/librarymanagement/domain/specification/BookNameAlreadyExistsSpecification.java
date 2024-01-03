package com.karam.librarymanagement.domain.specification;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;

public class BookNameAlreadyExistsSpecification extends SpecificationValidation<Book> {

    private BookRepository repository;

    public BookNameAlreadyExistsSpecification(BookRepository repository) {
        this.repository = repository;
    }

    public boolean isSatisfied(Book book) {
        var isThereBook = repository.doesBookExist(book);
        return !isThereBook;
    }

    @Override
    void setNext(Book entity) {

    }
}
