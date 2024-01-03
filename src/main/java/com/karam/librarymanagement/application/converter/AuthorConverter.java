package com.karam.librarymanagement.application.converter;

import com.karam.librarymanagement.application.dto.CreateAuthorOutputDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthorConverter {

    public CreateAuthorOutputDTO toCreateAuthorOutputDTO(Long id) {
        return new CreateAuthorOutputDTO(id);
    }
}
