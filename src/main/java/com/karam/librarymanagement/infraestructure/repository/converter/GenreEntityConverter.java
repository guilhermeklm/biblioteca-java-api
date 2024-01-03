package com.karam.librarymanagement.infraestructure.repository.converter;

import com.karam.librarymanagement.domain.Genre;
import com.karam.librarymanagement.infraestructure.entity.GenreEntity;
import org.springframework.stereotype.Service;

@Service
public class GenreEntityConverter {

    public Genre toGenre(GenreEntity genreEntity) {
        return new Genre(genreEntity.getId(), genreEntity.getNome());
    }

    public GenreEntity toGenreEntity(Genre genre) {
        return new GenreEntity(genre.getId(), genre.getName());
    }
}
