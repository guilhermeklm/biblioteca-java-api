package com.karam.librarymanagement.application.converter;

import com.karam.librarymanagement.application.dto.BookOutputDTO;
import com.karam.librarymanagement.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class BookConverter {

    public BookOutputDTO toBookOutputDTO(Book book) {
        return new BookOutputDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthorId(),
                book.getPublisherId(),
                book.getYearPublication(),
                book.getGenreId()
        );
    }
}
