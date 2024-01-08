package com.karam.librarymanagement.application.config;

import com.karam.librarymanagement.domain.specification.publisher.CreatePublisherSpecification;
import com.karam.librarymanagement.infraestructure.repository.publisher.PublisherRepository;
import com.karam.librarymanagement.usecase.publisher.CreatePublisherUseCase;
import com.karam.librarymanagement.usecase.publisher.converter.CreatePublisherConverter;
import com.karam.librarymanagement.usecase.publisher.impl.CreatePublisherUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatePublisherUseCaseConfig {

    @Bean
    public CreatePublisherUseCase createPublisherUseCaseImpl (PublisherRepository repository) {
        var publisherConverter = new CreatePublisherConverter();
        var specification = new CreatePublisherSpecification(repository);
        return new CreatePublisherUseCaseImpl(repository, publisherConverter, specification);
    }
}
