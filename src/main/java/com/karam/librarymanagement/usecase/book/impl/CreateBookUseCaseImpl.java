package com.karam.librarymanagement.usecase.book.impl;

import com.karam.librarymanagement.application.dto.CreateBookInputDTO;
import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.SpecificationTemplate;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.usecase.BaseUseCase;
import com.karam.librarymanagement.usecase.CreateDomainConverter;
import com.karam.librarymanagement.usecase.book.CreateBookUseCase;

public class CreateBookUseCaseImpl extends BaseUseCase<Book, CreateBookInputDTO> implements CreateBookUseCase {

    private BookRepository repository;
    public CreateBookUseCaseImpl(CreateDomainConverter createBookConverterImpl,
                                 SpecificationTemplate createBookSpecification,
                                 BookRepository repository) {
        super(createBookConverterImpl, createBookSpecification);
        this.repository = repository;
    }

    @Override
    public Long create(CreateBookInputDTO createBookInputDTO) {
        var book = getConverter().toDomain(createBookInputDTO);

        getSpecification().validate(book);

        return repository.save(book);
    }
}
