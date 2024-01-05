package com.karam.librarymanagement.usecase;

import com.karam.librarymanagement.domain.Domain;

public interface Converter<D extends Domain, InputDTO> {

    D toDomain(InputDTO dto);
}
