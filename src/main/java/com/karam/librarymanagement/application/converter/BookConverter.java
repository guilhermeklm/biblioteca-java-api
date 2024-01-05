package com.karam.librarymanagement.application.converter;

import com.karam.librarymanagement.application.dto.CreateBookOutputDTO;
import com.karam.librarymanagement.application.dto.GetBookOutputDTO;
import com.karam.librarymanagement.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class BookConverter {

    public CreateBookOutputDTO toCreateBookOutput(Long bookId) {
        return new CreateBookOutputDTO(bookId);
    }

    public GetBookOutputDTO toGetBookOutputDTO(Book book) {
        return new GetBookOutputDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthorId(),
                book.getPublisherId(),
                book.getYearPublication(),
                book.getGenreId()
        );
    }
}
