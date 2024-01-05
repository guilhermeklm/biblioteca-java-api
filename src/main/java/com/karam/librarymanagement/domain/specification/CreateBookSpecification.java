package com.karam.librarymanagement.domain.specification;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;

import java.util.ArrayList;

public class CreateBookSpecification extends SpecificationTemplate<Book> {

    private BookRepository repository;

    public CreateBookSpecification(BookRepository repository) {
        this.repository = repository;
    }
    @Override
    void addSpecifications() {
        var specifications = new ArrayList<EntitySpecification<Book>>();
        specifications.add(new BookNameAlreadyExistsEntitySpecification(repository));
        specifications.add(new BookAlreadyExistsEntitySpecification(repository));
        this.setEntitySpecifications(specifications);
    }
}
