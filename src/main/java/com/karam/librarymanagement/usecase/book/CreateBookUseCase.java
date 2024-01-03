package com.karam.librarymanagement.usecase.book;

import com.karam.librarymanagement.application.dto.CreateBookInputDTO;

public interface CreateBookUseCase {

    Long create(CreateBookInputDTO createBookInputDTO);
}
