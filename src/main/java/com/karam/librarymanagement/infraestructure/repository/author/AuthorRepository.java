package com.karam.librarymanagement.infraestructure.repository.author;

import com.karam.librarymanagement.domain.Author;

public interface AuthorRepository {

    Long save(Author author);

    Author findById(Long id);
}
