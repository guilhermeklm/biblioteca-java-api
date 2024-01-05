package com.karam.librarymanagement.usecase.publisher;

import com.karam.librarymanagement.application.dto.CreatePublisherInputDTO;

public interface CreatePublisherUseCase {

    Long create(CreatePublisherInputDTO dto);
}
