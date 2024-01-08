package com.karam.librarymanagement.application.config;

import com.karam.librarymanagement.domain.specification.book.UpdateBookSpecification;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.infraestructure.repository.genre.GenreRepository;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;
import com.karam.librarymanagement.usecase.book.UpdateBookUseCase;
import com.karam.librarymanagement.usecase.book.converter.UpdateBookConverter;
import com.karam.librarymanagement.usecase.book.impl.UpdateBookUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateBookUseCaseConfig {

    @Bean
    public UpdateBookUseCase updateBookUseCase(BookRepository repository,
                                               AuthorRepository authorRepository,
                                               PublisherRepository publisherRepository,
                                               GenreRepository genreRepository) {

        var updateBookConverter = new UpdateBookConverter(
                authorRepository,
                publisherRepository,
                genreRepository
        );
        var specification = new UpdateBookSpecification(repository);

        return new UpdateBookUseCaseImpl(updateBookConverter, specification, repository);
    }
}
