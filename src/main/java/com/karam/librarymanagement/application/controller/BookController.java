package com.karam.librarymanagement.application.controller;

import com.karam.librarymanagement.application.converter.BookConverter;
import com.karam.librarymanagement.application.dto.CreateBookInputDTO;
import com.karam.librarymanagement.application.dto.response.ApiSuccessResponse;
import com.karam.librarymanagement.application.dto.response.Message;
import com.karam.librarymanagement.usecase.book.CreateBookUseCase;
import com.karam.librarymanagement.usecase.book.GetBookUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController extends BaseController{

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
    public ResponseEntity<ApiSuccessResponse> create (@RequestBody CreateBookInputDTO createBookInputDTO,
                                                      HttpServletRequest request) {
        var bookId = createBookUseCase.create(createBookInputDTO);
        var createBookOutput = converter.toCreateBookOutput(bookId);

        return sendCreatedStatus(
                request,
                createBookOutput,
                new Message("key", "Livro criado com sucesso!")
        );
    }

    @GetMapping("/{bookId}")
    @ResponseBody
    public ResponseEntity<ApiSuccessResponse> getBook (@PathVariable(name = "bookId") Long bookId,
                                                       HttpServletRequest request) {
        var book = getBookUseCase.getById(bookId);
        var geBookOutputDTO = converter.toGetBookOutputDTO(book);

        return sendOkStatus(
                request,
                geBookOutputDTO,
                new Message("key", "Retrivied book")
        );
    }
}
