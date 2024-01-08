package com.karam.librarymanagement.usecase.book.converter;

import com.karam.librarymanagement.application.dto.UpdateBookInputDTO;
import com.karam.librarymanagement.domain.Author;
import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.domain.Genre;
import com.karam.librarymanagement.domain.Publisher;
import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.infraestructure.repository.genre.GenreRepository;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;
import com.karam.librarymanagement.usecase.Converter;

import java.util.Objects;

public class PartialUpdateBookConverter implements Converter<Book, UpdateBookInputDTO> {

    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    private PublisherRepository publisherRepository;

    private GenreRepository genreRepository;

    public PartialUpdateBookConverter(BookRepository bookRepository,
                                      AuthorRepository authorRepository,
                                      PublisherRepository publisherRepository,
                                      GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Book convert(UpdateBookInputDTO dto) {
        var bookSaved = bookRepository.findById(dto.getIsbn());
        var author = buildAuthor(bookSaved, dto);
        var publisher = buildPublisher(bookSaved, dto);
        var genre = buildGenre(bookSaved, dto);

        return new Book.Builder()
                .isbn(buildIsbn(bookSaved, dto))
                .title(buildTitle(bookSaved, dto))
                .author(author)
                .publisher(publisher)
                .yearPublication(buildYearPublication(bookSaved, dto))
                .genre(genre)
                .build();
    }

    private Author buildAuthor (Book bookSaved, UpdateBookInputDTO dto) {
        if (Objects.isNull(dto.getAuthorId())) {
            return bookSaved.getAuthor();
        }

        return authorRepository.findById(dto.getAuthorId());
    }

    private Publisher buildPublisher (Book bookSaved, UpdateBookInputDTO dto) {
        if (Objects.isNull(dto.getPublisherId())) {
            return bookSaved.getPublisher();
        }

        return publisherRepository.findById(dto.getPublisherId());
    }

    private Genre buildGenre (Book bookSaved, UpdateBookInputDTO dto) {
        if (Objects.isNull(dto.getGenreId())) {
            return bookSaved.getGenre();
        }

        return genreRepository.findById(dto.getGenreId());
    }

    private Long buildIsbn(Book bookSaved, UpdateBookInputDTO dto) {
        return dto.getIsbn() != null ? dto.getIsbn() : bookSaved.getId();
    }

    private String buildTitle(Book bookSaved, UpdateBookInputDTO dto) {
        return dto.getTitle() != null ? dto.getTitle() : bookSaved.getTitle();
    }

    private String buildYearPublication(Book bookSaved, UpdateBookInputDTO dto) {
        return dto.getYearPublication() != null
                ? dto.getYearPublication() : bookSaved.getYearPublication();
    }
}
