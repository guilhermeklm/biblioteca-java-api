package com.karam.librarymanagement.domain.specification.book;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.EntitySpecification;
import com.karam.librarymanagement.domain.specification.SpecificationTemplate;
import com.karam.librarymanagement.domain.specification.book.rules.BookNotExistsSpecification;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;

import java.util.ArrayList;

public class UpdateBookSpecification extends SpecificationTemplate<Book> {

    private BookRepository repository;

    public UpdateBookSpecification(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void addSpecifications() {
        var specifications = new ArrayList<EntitySpecification<Book>>();
        specifications.add(new BookNotExistsSpecification(repository));
        this.setEntitySpecifications(specifications);
    }
}
