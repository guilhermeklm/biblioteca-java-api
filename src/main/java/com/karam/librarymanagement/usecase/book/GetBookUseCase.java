package com.karam.librarymanagement.usecase.book;

import com.karam.librarymanagement.domain.Book;

public interface GetBookUseCase {

    Book getById(Long bookId);
}
