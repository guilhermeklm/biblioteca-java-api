package com.karam.librarymanagement.domain.specification.book;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.domain.specification.SpecificationTemplate;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;

import java.util.ArrayList;

public class CreateBookSpecification extends SpecificationTemplate<Book> {

    private BookRepository repository;

    public CreateBookSpecification(BookRepository repository) {
        this.repository = repository;
    }
    @Override
    public void addSpecifications(Book newBook) {
        var specifications = new ArrayList<EntitySpecification<Book>>();
        specifications.add(new BookNameAlreadyExistsEntitySpecification(newBook, repository));
        specifications.add(new BookAlreadyExistsEntitySpecification(newBook, repository));
        this.setEntitySpecifications(specifications);
    }
}
