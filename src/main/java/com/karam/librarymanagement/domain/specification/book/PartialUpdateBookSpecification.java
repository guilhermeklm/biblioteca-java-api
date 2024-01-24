package com.karam.librarymanagement.domain.specification.book;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.domain.specification.SpecificationTemplate;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;

import java.util.ArrayList;

public class PartialUpdateBookSpecification extends SpecificationTemplate<Book> {

    private BookRepository repository;

    public PartialUpdateBookSpecification(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    @Override
    protected void addSpecifications(Book newBook) {
        var specifications = new ArrayList<EntitySpecification<Book>>();
        var oldBook = repository.findById(newBook.getId());
        var modifiedFields = oldBook.modifiedFields(newBook, oldBook);

        if (modifiedFields.contains("title")) {
            specifications.add(new BookNameAlreadyExistsEntitySpecification(newBook, repository));
        }

        if (modifiedFields.contains("author")) {
            specifications.add(new LimitBooksByAnAuthorExceeded(newBook, repository));
        }

        if (!modifiedFields.isEmpty()){
            specifications.add(new BookAlreadyExistsEntitySpecification(newBook, repository));
        }

        this.setEntitySpecifications(specifications);
    }
}
