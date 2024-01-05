package com.karam.librarymanagement.infraestructure.repository.book.impl;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.infraestructure.repository.book.BookJpaRepository;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.infraestructure.converter.BookEntityConverter;
import com.karam.librarymanagement.infraestructure.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class BookRepositoryImpl implements BookRepository {

    private BookJpaRepository bookJpaRepository;

    private BookEntityConverter bookEntityConverter;

    public BookRepositoryImpl(BookJpaRepository bookJpaRepository,
                              BookEntityConverter bookEntityConverter) {
        this.bookJpaRepository = bookJpaRepository;
        this.bookEntityConverter = bookEntityConverter;
    }

    public Long save(Book book) {
        var bookEntity = bookEntityConverter.toBookEntity(book);
        var bookEntitySaved = bookJpaRepository.save(bookEntity);
        return bookEntitySaved.getIsbn();
    }

    public Book findById(Long bookId) {
        var bookEntity = bookJpaRepository.findById(bookId);

        if (bookEntity.isPresent()) {
            return bookEntityConverter.toBook(bookEntity.get());
        }

        throw new EntityNotFoundException("Book not found");
    }

    @Override
    public Long findIdByBook(Book book) {
        var bookEntity = bookEntityConverter.toBookEntity(book);
        return bookJpaRepository.findIdByBook(
                bookEntity.getTitle(),
                bookEntity.getAuthorId(),
                bookEntity.getPublisherId(),
                bookEntity.getYearPublication(),
                bookEntity.getGenreId()
        );
    }

    @Override
    public Long findIdByTitle(String title) {
        return bookJpaRepository.findIdByTitle(title);
    }
}
