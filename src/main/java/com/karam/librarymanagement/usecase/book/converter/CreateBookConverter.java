package com.karam.librarymanagement.usecase.book.converter;

import com.karam.librarymanagement.application.dto.CreateBookInputDTO;
import com.karam.librarymanagement.domain.Book;

public interface CreateBookConverter {

    Book toBook(CreateBookInputDTO dto);
}
