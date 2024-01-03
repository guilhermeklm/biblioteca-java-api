package com.karam.librarymanagement.application.config;

import com.karam.librarymanagement.infraestructure.repository.book.BookRepository;
import com.karam.librarymanagement.usecase.book.GetBookUseCase;
import com.karam.librarymanagement.usecase.book.impl.GetBookUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetBookUseCaseConfig {

    @Bean
    public GetBookUseCase initializateGetBookUseCase(BookRepository bookRepository) {
        return new GetBookUseCaseImpl(bookRepository);
    }
}
