package com.karam.librarymanagement.usecase.book.impl;

import com.karam.librarymanagement.application.dto.UpdateBookInputDTO;
import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.specification.book.PartialUpdateBookSpecification;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.usecase.BaseUseCase;
import com.karam.librarymanagement.usecase.book.PartialUpdateBookUseCase;
import com.karam.librarymanagement.usecase.book.converter.PartialUpdateBookConverter;

public class PartialUpdateBookUseImpl extends BaseUseCase<Book, UpdateBookInputDTO> implements PartialUpdateBookUseCase {

    private BookRepository repository;

    public PartialUpdateBookUseImpl(PartialUpdateBookConverter converter,
                                    PartialUpdateBookSpecification specification,
                                    BookRepository repository) {
        super(converter, specification);
        this.repository = repository;
    }

    @Override
    public Book partialUpdate(UpdateBookInputDTO dto) {
        var book = getConverter().convert(dto);

        getSpecification().validate(book);

        return repository.save(book);
    }
}
