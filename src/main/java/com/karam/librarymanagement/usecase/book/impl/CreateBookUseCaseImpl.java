package com.karam.librarymanagement.usecase.book.impl;

import com.karam.librarymanagement.application.dto.CreateBookInputDTO;
import com.karam.librarymanagement.domain.specification.book.CreateBookSpecification;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.usecase.book.CreateBookUseCase;
import com.karam.librarymanagement.usecase.book.converter.CreateBookConverter;

public class CreateBookUseCaseImpl implements CreateBookUseCase {

    private CreateBookConverter converter;

    private BookRepository bookRepository;

    private CreateBookSpecification specification;

    public CreateBookUseCaseImpl(CreateBookConverter converter,
                                 BookRepository bookRepository,
                                 CreateBookSpecification createBookSpecification) {
        this.converter = converter;
        this.bookRepository = bookRepository;
        this.specification = createBookSpecification;
    }

    @Override
    public Long create(CreateBookInputDTO createBookInputDTO) {
        var book = converter.toBook(createBookInputDTO);

        specification.validate(book);

        return bookRepository.save(book);
    }
}
