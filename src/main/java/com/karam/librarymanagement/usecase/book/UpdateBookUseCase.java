package com.karam.librarymanagement.usecase.book;

import com.karam.librarymanagement.application.dto.UpdateBookInputDTO;
import com.karam.librarymanagement.domain.Book;

public interface UpdateBookUseCase {

    Book update(UpdateBookInputDTO dto);
}
