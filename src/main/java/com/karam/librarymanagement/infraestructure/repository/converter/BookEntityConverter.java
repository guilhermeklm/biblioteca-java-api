package com.karam.librarymanagement.infraestructure.repository.converter;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.infraestructure.entity.BookEntity;
import org.springframework.stereotype.Service;

@Service
public class BookEntityConverter {

    private AuthorEntityConverter authorEntityConverter;

    private PublisherEntityConverter publisherEntityConverter;

    private GenreEntityConverter genreEntityConverter;

    public BookEntityConverter(AuthorEntityConverter authorEntityConverter,
                               PublisherEntityConverter publisherEntityConverter,
                               GenreEntityConverter genreEntityConverter) {
        this.authorEntityConverter = authorEntityConverter;
        this.publisherEntityConverter = publisherEntityConverter;
        this.genreEntityConverter = genreEntityConverter;
    }

    public BookEntity toBookEntity(Book book) {
        var author = authorEntityConverter.toAuthorEntity(book.getAuthor());
        var publisher = publisherEntityConverter.toPublisherEntity(book.getPublisher());
        var genre = genreEntityConverter.toGenreEntity(book.getGenre());

        return new BookEntity(
                book.getIsbn(),
                book.getTitle(),
                author,
                publisher,
                book.getYearPublication(),
                genre
        );
    }

    public Book toBook(BookEntity bookEntity) {
        var author = authorEntityConverter.toAuthor(bookEntity.getAuthor());
        var publisher = publisherEntityConverter.toPublisher(bookEntity.getPublisher());
        var genre = genreEntityConverter.toGenre(bookEntity.getGenre());

        return new Book.Builder()
                .isbn(bookEntity.getIsbn())
                .title(bookEntity.getTitle())
                .author(author)
                .publisher(publisher)
                .yearPublication(bookEntity.getYearPublication())
                .genre(genre)
                .build();
    }
}
