package com.karam.librarymanagement.application.config;

import com.karam.librarymanagement.infraestructure.repository.author.AuthorRepository;
import com.karam.librarymanagement.usecase.author.converter.CreateAuthorConverter;
import com.karam.librarymanagement.usecase.author.impl.CreateAuthorUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateAuthorUseCaseConfig {

    @Bean
    public CreateAuthorUseCaseImpl createAuthorUseCase(AuthorRepository repository) {
        var converter = new CreateAuthorConverter();

        return new CreateAuthorUseCaseImpl(repository, converter);
    }
}
