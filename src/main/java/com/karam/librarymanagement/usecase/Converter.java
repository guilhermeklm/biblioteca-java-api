package com.karam.librarymanagement.usecase;

public interface Converter<Domain, InputDTO> {

    Domain toDomain(InputDTO dto);
}
