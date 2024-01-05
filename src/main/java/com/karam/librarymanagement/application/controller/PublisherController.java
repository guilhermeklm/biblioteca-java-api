package com.karam.librarymanagement.application.controller;

import com.karam.librarymanagement.application.converter.PublisherConverter;
import com.karam.librarymanagement.application.dto.CreatePublisherInputDTO;
import com.karam.librarymanagement.application.dto.response.ApiSuccessResponse;
import com.karam.librarymanagement.application.dto.response.LinksResponse;
import com.karam.librarymanagement.application.dto.response.Message;
import com.karam.librarymanagement.usecase.publisher.CreatePublisherUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private PublisherConverter publisherConverter;
    private CreatePublisherUseCase createPublisherUseCase;

    public PublisherController(PublisherConverter converter,
                               CreatePublisherUseCase createPublisherUseCase) {
        this.publisherConverter = converter;
        this.createPublisherUseCase = createPublisherUseCase;
    }

    @PostMapping
    public ResponseEntity<ApiSuccessResponse> create(@RequestBody CreatePublisherInputDTO dto) {
        var publisherId = createPublisherUseCase.create(dto);
        var publisherOutputDTO = publisherConverter.toCreatePublisherOutputDTO(publisherId);
        var apiResponse = new ApiSuccessResponse(
                201,
                new LinksResponse("/publishers", "POST"),
                List.of(new Message("key", "Editora criado com sucesso!")),
                publisherOutputDTO
        );
        return ResponseEntity.status(201).body(apiResponse);
    }
}
