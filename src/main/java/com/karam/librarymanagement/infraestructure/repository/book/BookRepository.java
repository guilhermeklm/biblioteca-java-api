package com.karam.librarymanagement.infraestructure.repository.book;

import com.karam.librarymanagement.domain.Book;

public interface BookRepository {

    Long save(Book book);

    Book findById(Long bookId);

    boolean doesBookExist(Book book);
}
