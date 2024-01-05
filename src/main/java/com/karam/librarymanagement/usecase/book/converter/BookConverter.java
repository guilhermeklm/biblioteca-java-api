package com.karam.librarymanagement.usecase.book.converter;

import com.karam.librarymanagement.application.dto.CreateBookInputDTO;
import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;
import com.karam.librarymanagement.infraestructure.repository.genre.GenreRepository;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;
import com.karam.librarymanagement.usecase.Converter;

public class BookConverter implements Converter<Book, CreateBookInputDTO> {

    private AuthorRepository authorRepository;

    private PublisherRepository publisherRepository;

    private GenreRepository genreRepository;

    public BookConverter(AuthorRepository authorRepository,
                         PublisherRepository publisherRepository,
                         GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Book toDomain(CreateBookInputDTO dto) {
        var author = authorRepository.findById(dto.authorId());
        var publisher = publisherRepository.findById(dto.publisherId());
        var genre = genreRepository.findById(dto.genreId());

        return new Book.Builder()
                .title(dto.title())
                .author(author)
                .publisher(publisher)
                .yearPublication(dto.yearPublication())
                .genre(genre)
                .build();
    }
}
