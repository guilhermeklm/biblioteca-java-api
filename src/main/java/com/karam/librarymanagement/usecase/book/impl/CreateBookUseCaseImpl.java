package com.karam.librarymanagement.usecase.book.impl;

import com.karam.librarymanagement.application.dto.CreateBookInputDTO;
import com.karam.librarymanagement.domain.specification.book.CreateBookSpecification;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.usecase.BaseUseCase;
import com.karam.librarymanagement.usecase.book.CreateBookUseCase;
import com.karam.librarymanagement.usecase.book.converter.BookConverter;

public class CreateBookUseCaseImpl extends BaseUseCase implements CreateBookUseCase {

    private BookConverter converter;

    private BookRepository bookRepository;

    private CreateBookSpecification specification;

    public CreateBookUseCaseImpl(BookConverter converter,
                                 BookRepository bookRepository,
                                 CreateBookSpecification createBookSpecification) {
        this.converter = converter;
        this.bookRepository = bookRepository;
        this.specification = createBookSpecification;
    }

    @Override
    public Long create(CreateBookInputDTO createBookInputDTO) {
        var book = converter.toDomain(createBookInputDTO);

        specification.validate(book);

        return bookRepository.save(book);
    }
}
