package com.karam.librarymanagement.application.controller;

import com.karam.librarymanagement.application.converter.BookConverter;
import com.karam.librarymanagement.application.dto.CreateBookInputDTO;
import com.karam.librarymanagement.application.dto.response.ApiSuccessResponse;
import com.karam.librarymanagement.application.dto.response.LinksResponse;
import com.karam.librarymanagement.application.dto.response.Message;
import com.karam.librarymanagement.usecase.book.CreateBookUseCase;
import com.karam.librarymanagement.usecase.book.GetBookUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final CreateBookUseCase createBookUseCase;

    private final GetBookUseCase getBookUseCase;

    private final BookConverter converter;

    public BookController(CreateBookUseCase createBookUseCase, GetBookUseCase getBookUseCase, BookConverter converter) {
        this.createBookUseCase = createBookUseCase;
        this.getBookUseCase = getBookUseCase;
        this.converter = converter;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ApiSuccessResponse> create (@RequestBody CreateBookInputDTO createBookInputDTO) {
        var bookId = createBookUseCase.create(createBookInputDTO);
        var createBookOutput = converter.toCreateBookOutput(bookId);
        var apiResponse = new ApiSuccessResponse(
                201,
                new LinksResponse("/books", "POST"),
                List.of(new Message("key", "Livro criado com sucesso!")),
                createBookOutput
        );
        return ResponseEntity.status(201).body(apiResponse);
    }

    @GetMapping("/{bookId}")
    @ResponseBody
    public ResponseEntity<ApiSuccessResponse> getBook (@PathVariable(name = "bookId") Long bookId) {
        var book = getBookUseCase.getById(bookId);
        var geBookOutputDTO = converter.toGetBookOutputDTO(book);
        var apiResponse = new ApiSuccessResponse(
                200,
                new LinksResponse("/books", "POST"),
                List.of(new Message("key", "Retrivied book")),
                geBookOutputDTO
        );
        return ResponseEntity.ok(apiResponse);
    }
}
