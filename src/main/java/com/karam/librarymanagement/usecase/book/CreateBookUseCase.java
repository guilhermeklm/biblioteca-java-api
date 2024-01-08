package com.karam.librarymanagement.usecase.book;

import com.karam.librarymanagement.application.dto.CreateBookInputDTO;
import com.karam.librarymanagement.domain.Book;

public interface CreateBookUseCase {

    Book create(CreateBookInputDTO createBookInputDTO);
}
