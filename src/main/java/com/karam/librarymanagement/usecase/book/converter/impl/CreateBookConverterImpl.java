package com.karam.librarymanagement.usecase.book.converter.impl;

import com.karam.librarymanagement.application.dto.CreateBookInputDTO;
import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;
import com.karam.librarymanagement.infraestructure.repository.genre.GenreRepository;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;
import com.karam.librarymanagement.usecase.book.converter.CreateBookConverter;

public class CreateBookConverterImpl implements CreateBookConverter {

    private AuthorRepository authorRepository;

    private PublisherRepository publisherRepository;

    private GenreRepository genreRepository;

    public CreateBookConverterImpl(AuthorRepository authorRepository,
                                   PublisherRepository publisherRepository,
                                   GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.genreRepository = genreRepository;
    }

    public Book toBook(CreateBookInputDTO createBookInputDTO) {
        var author = authorRepository.findById(createBookInputDTO.authorId());
        var publisher = publisherRepository.findById(createBookInputDTO.publisherId());
        var genre = genreRepository.findById(createBookInputDTO.genreId());

        return new Book.Builder()
                .title(createBookInputDTO.title())
                .author(author)
                .publisher(publisher)
                .yearPublication(createBookInputDTO.yearPublication())
                .genre(genre)
                .build();
    }
}
