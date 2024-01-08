package com.karam.librarymanagement.usecase.book.impl;

import com.karam.librarymanagement.application.dto.CreateBookInputDTO;
import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.book.CreateBookSpecification;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.usecase.BaseUseCase;
import com.karam.librarymanagement.usecase.book.CreateBookUseCase;
import com.karam.librarymanagement.usecase.book.converter.CreateBookConverter;

public class CreateBookUseCaseImpl extends BaseUseCase<Book, CreateBookInputDTO> implements CreateBookUseCase {

    private BookRepository repository;
    public CreateBookUseCaseImpl(CreateBookConverter createBookConverterImpl,
                                 CreateBookSpecification createBookSpecification,
                                 BookRepository repository) {
        super(createBookConverterImpl, createBookSpecification);
        this.repository = repository;
    }

    @Override
    public Book create(CreateBookInputDTO createBookInputDTO) {
        var book = getConverter().convert(createBookInputDTO);

        getSpecification().validate(book);

        return repository.save(book);
    }
}
