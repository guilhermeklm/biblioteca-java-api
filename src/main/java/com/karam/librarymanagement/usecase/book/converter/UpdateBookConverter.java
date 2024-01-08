package com.karam.librarymanagement.usecase.book.converter;

import com.karam.librarymanagement.application.dto.UpdateBookInputDTO;
import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;
import com.karam.librarymanagement.infraestructure.repository.genre.GenreRepository;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;
import com.karam.librarymanagement.usecase.Converter;

public class UpdateBookConverter implements Converter<Book, UpdateBookInputDTO> {

    private AuthorRepository authorRepository;

    private PublisherRepository publisherRepository;

    private GenreRepository genreRepository;

    public UpdateBookConverter(AuthorRepository authorRepository,
                               PublisherRepository publisherRepository,
                               GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Book convert(UpdateBookInputDTO dto) {
        var author = authorRepository.findById(dto.getAuthorId());
        var publisher = publisherRepository.findById(dto.getPublisherId());
        var genre = genreRepository.findById(dto.getGenreId());

        return new Book.Builder()
                .isbn(dto.getIsbn())
                .title(dto.getTitle())
                .author(author)
                .publisher(publisher)
                .yearPublication(dto.getYearPublication())
                .genre(genre)
                .build();
    }
}
