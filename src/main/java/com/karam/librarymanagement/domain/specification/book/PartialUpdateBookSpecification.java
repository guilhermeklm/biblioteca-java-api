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
    protected void addSpecifications() {
        //TODO - precisa validar somente os campos q editei
        var specifications = new ArrayList<EntitySpecification<Book>>();
        this.setEntitySpecifications(specifications);
    }
}
