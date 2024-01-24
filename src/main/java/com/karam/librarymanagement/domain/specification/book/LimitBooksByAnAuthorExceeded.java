package com.karam.librarymanagement.domain.specification.book;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;

public class LimitBooksByAnAuthorExceeded extends EntitySpecification<Book> {

    private BookRepository repository;

    public LimitBooksByAnAuthorExceeded(Book newBook, BookRepository repository) {
        super(newBook);
        this.repository = repository;
    }

    @Override
    public void validate() {
        var booksAuthor = repository.countBooksByAuthorId(this.getDomain().getAuthorId());

        if (booksAuthor >= 3) {
            addErrorMessage("Limite de livros excedido para o author " + this.getDomain().getAuthor().getName());
        }
    }
}
