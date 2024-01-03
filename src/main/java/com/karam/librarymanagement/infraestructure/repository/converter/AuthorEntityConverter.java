package com.karam.librarymanagement.infraestructure.repository.converter;

import com.karam.librarymanagement.domain.Author;
import com.karam.librarymanagement.infraestructure.entity.AuthorEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorEntityConverter {

    public AuthorEntity toAuthorEntity(Author author) {
        return new AuthorEntity(
                author.getId(),
                author.getName(),
                author.getCountry()
        );
    }

    public Author toAuthor(AuthorEntity authorEntity) {
        return new Author.Builder()
                .id(authorEntity.getId())
                .name(authorEntity.getName())
                .country(authorEntity.getCountry())
                .build();
    }
}
