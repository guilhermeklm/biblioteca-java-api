package com.karam.librarymanagement.infraestructure.repository.book.impl;

import com.karam.librarymanagement.domain.Book;
import com.karam.librarymanagement.infraestructure.converter.BookEntityConverter;
import com.karam.librarymanagement.infraestructure.exception.EntityNotFoundException;
import com.karam.librarymanagement.infraestructure.repository.book.BookJpaRepository;
import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import org.springframework.stereotype.Component;

@Component
class BookRepositoryImpl implements BookRepository {

    private final BookJpaRepository bookJpaRepository;

    private final BookEntityConverter bookEntityConverter;

    public BookRepositoryImpl(BookJpaRepository bookJpaRepository,
                              BookEntityConverter bookEntityConverter) {
        this.bookJpaRepository = bookJpaRepository;
        this.bookEntityConverter = bookEntityConverter;
    }

    public Book save(Book book) {
        var bookEntity = bookEntityConverter.toBookEntity(book);
        var bookEntitySaved = bookJpaRepository.save(bookEntity);
        return bookEntityConverter.toBook(bookEntitySaved);
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

    @Override
    public boolean existsById(Long bookId) {
        return bookJpaRepository.existsById(bookId);
    }

    @Override
    public long countBooksByAuthorId(Long authorId) {
        return bookJpaRepository.countByAuthorId(authorId);
    }
}
