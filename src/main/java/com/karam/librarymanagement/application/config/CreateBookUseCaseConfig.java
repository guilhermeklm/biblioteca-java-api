package com.karam.librarymanagement.application.config;

import com.karam.librarymanagement.domain.specification.book.CreateBookSpecification;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.infraestructure.repository.genre.GenreRepository;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;
import com.karam.librarymanagement.usecase.book.CreateBookUseCase;
import com.karam.librarymanagement.usecase.book.converter.CreateBookConverter;
import com.karam.librarymanagement.usecase.book.impl.CreateBookUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateBookUseCaseConfig {

    @Bean
    public CreateBookUseCase initializateCreateBookUseCase(BookRepository bookRepository,
                                                           AuthorRepository authorRepository,
                                                           PublisherRepository publisherRepository,
                                                           GenreRepository genreRepository) {

        var createBookConverterImpl = new CreateBookConverter(
                authorRepository,
                publisherRepository,
                genreRepository
        );
        var createBookSpecification = new CreateBookSpecification(bookRepository);

        return new CreateBookUseCaseImpl(createBookConverterImpl, createBookSpecification, bookRepository);
    }
}
