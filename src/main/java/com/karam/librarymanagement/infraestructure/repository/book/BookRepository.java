package com.karam.librarymanagement.infraestructure.repository.book;

import com.karam.librarymanagement.domain.Book;

public interface BookRepository {

    Book save(Book book);

    Book findById(Long bookId);

    Long findIdByBook(Book book);

    Long findIdByTitle(String title);

    boolean existsById(Long bookId);

    long countBooksByAuthorId(Long authorId);
}
