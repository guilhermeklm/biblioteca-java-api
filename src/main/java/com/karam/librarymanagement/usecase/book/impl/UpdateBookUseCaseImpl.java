package com.karam.librarymanagement.usecase.book.impl;

import com.karam.librarymanagement.application.dto.UpdateBookInputDTO;
import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.SpecificationTemplate;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.usecase.BaseUseCase;
import com.karam.librarymanagement.usecase.book.UpdateBookUseCase;
import com.karam.librarymanagement.usecase.book.converter.UpdateBookConverter;

public class UpdateBookUseCaseImpl extends BaseUseCase<Book, UpdateBookInputDTO> implements UpdateBookUseCase {

    private BookRepository bookRepository;

    public UpdateBookUseCaseImpl(UpdateBookConverter converter,
                                 SpecificationTemplate<Book> specification,
                                 BookRepository repository) {
        super(converter, specification);
        this.bookRepository = repository;
    }

    @Override
    public Book update(UpdateBookInputDTO dto) {
        var book = getConverter().convert(dto);

        getSpecification().validate(book);

        return bookRepository.save(book);
    }
}
