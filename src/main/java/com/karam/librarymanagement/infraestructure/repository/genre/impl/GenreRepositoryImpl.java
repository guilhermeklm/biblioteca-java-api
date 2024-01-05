package com.karam.librarymanagement.infraestructure.repository.genre.impl;

import com.karam.librarymanagement.domain.Genre;
import com.karam.librarymanagement.infraestructure.converter.GenreEntityConverter;
import com.karam.librarymanagement.infraestructure.exception.EntityNotFoundException;
import com.karam.librarymanagement.infraestructure.repository.genre.GenreJpaRepository;
import com.karam.librarymanagement.infraestructure.repository.genre.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreRepositoryImpl implements GenreRepository {

    private GenreJpaRepository jpaRepository;

    private GenreEntityConverter converter;

    public GenreRepositoryImpl(GenreJpaRepository jpaRepository,
                               GenreEntityConverter converter) {
        this.jpaRepository = jpaRepository;
        this.converter = converter;
    }

    @Override
    public Genre findById(Long id) {
        var genreEntity = jpaRepository.findById(id);

        if (genreEntity.isPresent()) {
            return converter.toGenre(genreEntity.get());
        }

        throw new EntityNotFoundException("Genre not found");
    }

    @Override
    public Long save(Genre genre) {
        var genreEntity = converter.toGenreEntity(genre);
        var genreEntitySaved = jpaRepository.save(genreEntity);
        return genreEntitySaved.getId();
    }
}
