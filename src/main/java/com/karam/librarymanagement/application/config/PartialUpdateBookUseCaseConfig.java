package com.karam.librarymanagement.application.config;

import com.karam.librarymanagement.domain.specification.book.PartialUpdateBookSpecification;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.infraestructure.repository.genre.GenreRepository;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;
import com.karam.librarymanagement.usecase.book.PartialUpdateBookUseCase;
import com.karam.librarymanagement.usecase.book.converter.PartialUpdateBookConverter;
import com.karam.librarymanagement.usecase.book.impl.PartialUpdateBookUseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PartialUpdateBookUseCaseConfig {

    @Bean
    public PartialUpdateBookUseCase partialUpdateBookUseCase(BookRepository repository,
                                                             AuthorRepository authorRepository,
                                                             PublisherRepository publisherRepository,
                                                             GenreRepository genreRepository
                                                             ) {
        var partialUpdateBookConverter = new PartialUpdateBookConverter(
                repository,
                authorRepository,
                publisherRepository,
                genreRepository
        );

        var specification = new PartialUpdateBookSpecification(repository);

        return new PartialUpdateBookUseImpl(partialUpdateBookConverter, specification, repository);
    }
}
