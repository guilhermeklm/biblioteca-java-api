package com.karam.librarymanagement.usecase.author;

import com.karam.librarymanagement.application.dto.CreateAuthorInputDTO;

public interface CreateAuthorUseCase {

    Long create(CreateAuthorInputDTO dto);
}
