package com.karam.librarymanagement.usecase.book.impl;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.usecase.book.GetBookUseCase;

public class GetBookUseCaseImpl implements GetBookUseCase {

    private BookRepository repository;

    public GetBookUseCaseImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book getById(Long bookId) {
        return repository.findById(bookId);
    }
}
