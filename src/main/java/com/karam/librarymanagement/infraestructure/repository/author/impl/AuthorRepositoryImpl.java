package com.karam.librarymanagement.infraestructure.repository.author.impl;

import com.karam.librarymanagement.domain.Author;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorJpaRepository;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;
import com.karam.librarymanagement.infraestructure.converter.AuthorEntityConverter;
import com.karam.librarymanagement.infraestructure.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorRepositoryImpl implements AuthorRepository {

    private AuthorEntityConverter converter;
    private AuthorJpaRepository jpaRepository;

    public AuthorRepositoryImpl(AuthorJpaRepository jpaRepository,
                                AuthorEntityConverter converter) {
        this.jpaRepository = jpaRepository;
        this.converter = converter;
    }

    @Override
    public Long save (Author author) {
        var authorEntity = converter.toAuthorEntity(author);
        var authorSaved = jpaRepository.save(authorEntity);
        return authorSaved.getId();
    }

    @Override
    public Author findById(Long id) {
        var authorEntity = jpaRepository.findById(id);

        if (authorEntity.isPresent()) {
            return converter.toAuthor(authorEntity.get());
        }

        throw new EntityNotFoundException("Author not found");
    }

    @Override
    public Long findIdByAuthor(Author author) {
        var bookEntity = converter.toAuthorEntity(author);
        return jpaRepository.findIdByAuthor(
                bookEntity.getName(),
                bookEntity.getCountry()
        );
    }
}
