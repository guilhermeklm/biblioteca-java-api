package com.karam.librarymanagement.application.controller;

import com.karam.librarymanagement.application.converter.PublisherConverter;
import com.karam.librarymanagement.application.dto.CreatePublisherInputDTO;
import com.karam.librarymanagement.application.dto.response.ApiSuccessResponse;
import com.karam.librarymanagement.application.dto.response.Message;
import com.karam.librarymanagement.usecase.publisher.CreatePublisherUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publishers")
public class PublisherController extends BaseController{

    private PublisherConverter publisherConverter;
    private CreatePublisherUseCase createPublisherUseCase;

    public PublisherController(PublisherConverter converter,
                               CreatePublisherUseCase createPublisherUseCase) {
        this.publisherConverter = converter;
        this.createPublisherUseCase = createPublisherUseCase;
    }

    @PostMapping
    public ResponseEntity<ApiSuccessResponse> create(HttpServletRequest request,
                                                     @RequestBody CreatePublisherInputDTO dto) {
        var publisherId = createPublisherUseCase.create(dto);
        var publisherOutputDTO = publisherConverter.toCreatePublisherOutputDTO(publisherId);

        return sendCreatedStatus(
                request,
                publisherOutputDTO,
                new Message("key", "Editora criado com sucesso!")
        );
    }
}
