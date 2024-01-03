package com.karam.librarymanagement.infraestructure.repository.genre;

import com.karam.librarymanagement.domain.Genre;

public interface GenreRepository {

    Genre findById (Long id);

    Long save (Genre genre);
}
