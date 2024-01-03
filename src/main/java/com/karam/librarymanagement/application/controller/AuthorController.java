package com.karam.librarymanagement.application.controller;

import com.karam.librarymanagement.application.converter.AuthorConverter;
import com.karam.librarymanagement.application.dto.CreateAuthorInputDTO;
import com.karam.librarymanagement.application.dto.response.ApiSuccessResponse;
import com.karam.librarymanagement.application.dto.response.LinksResponse;
import com.karam.librarymanagement.application.dto.response.Message;
import com.karam.librarymanagement.usecase.author.CreateAuthorUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private CreateAuthorUseCase createAuthorUseCase;

    private AuthorConverter converter;

    public AuthorController(CreateAuthorUseCase createAuthorUseCase,
                            AuthorConverter converter) {
        this.createAuthorUseCase = createAuthorUseCase;
        this.converter = converter;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ApiSuccessResponse> create(@RequestBody CreateAuthorInputDTO createAuthorInputDTO) {
        var authorId = createAuthorUseCase.create(createAuthorInputDTO);
        var createAuthorOutputDTO = converter.toCreateAuthorOutputDTO(authorId);
        var apiResponse = new ApiSuccessResponse(
                201,
                new LinksResponse("/authors", "POST"),
                List.of(new Message("key", "Author created")),
                createAuthorOutputDTO
        );
        return ResponseEntity.status(201).body(apiResponse);
    }
}
