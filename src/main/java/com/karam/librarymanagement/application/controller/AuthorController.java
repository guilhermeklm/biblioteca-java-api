package com.karam.librarymanagement.application.controller;

import com.karam.librarymanagement.application.converter.AuthorConverter;
import com.karam.librarymanagement.application.dto.CreateAuthorInputDTO;
import com.karam.librarymanagement.application.dto.response.ApiSuccessResponse;
import com.karam.librarymanagement.application.dto.response.Message;
import com.karam.librarymanagement.usecase.author.CreateAuthorUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController extends BaseController{

    private CreateAuthorUseCase createAuthorUseCase;

    private AuthorConverter converter;

    public AuthorController(CreateAuthorUseCase createAuthorUseCase,
                            AuthorConverter converter) {
        this.createAuthorUseCase = createAuthorUseCase;
        this.converter = converter;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ApiSuccessResponse> create(@RequestBody CreateAuthorInputDTO createAuthorInputDTO,
                                                     HttpServletRequest request) {
        var authorId = createAuthorUseCase.create(createAuthorInputDTO);
        var createAuthorOutputDTO = converter.toCreateAuthorOutputDTO(authorId);

        return sendCreatedStatus(
                request,
                createAuthorOutputDTO,
                new Message("key", "Author created")
        );
    }
}
