package com.karam.librarymanagement.application.controller;

import com.karam.librarymanagement.application.converter.BookConverter;
import com.karam.librarymanagement.application.dto.CreateBookInputDTO;
import com.karam.librarymanagement.application.dto.UpdateBookInputDTO;
import com.karam.librarymanagement.application.dto.response.ApiSuccessResponse;
import com.karam.librarymanagement.application.dto.response.Message;
import com.karam.librarymanagement.usecase.book.CreateBookUseCase;
import com.karam.librarymanagement.usecase.book.GetBookUseCase;
import com.karam.librarymanagement.usecase.book.PartialUpdateBookUseCase;
import com.karam.librarymanagement.usecase.book.UpdateBookUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/books")
public class BookController extends BaseController{

    private final CreateBookUseCase createBookUseCase;

    private final GetBookUseCase getBookUseCase;

    private final UpdateBookUseCase updateBookUseCase;

    private final PartialUpdateBookUseCase partialUpdateBookUseCase;

    private final BookConverter converter;

    public BookController(CreateBookUseCase createBookUseCase,
                          GetBookUseCase getBookUseCase,
                          UpdateBookUseCase updateBookUseCase,
                          PartialUpdateBookUseCase partialUpdateBookUseCase,
                          BookConverter converter) {
        this.createBookUseCase = createBookUseCase;
        this.getBookUseCase = getBookUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.partialUpdateBookUseCase = partialUpdateBookUseCase;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<ApiSuccessResponse> create (@RequestBody CreateBookInputDTO createBookInputDTO,
                                                      HttpServletRequest request) {
        var book = createBookUseCase.create(createBookInputDTO);
        var createBookOutput = converter.toBookOutputDTO(book);

        return sendCreatedStatus(
                request,
                createBookOutput,
                new Message("key", "Livro criado com sucesso!")
        );
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<ApiSuccessResponse> getBook (@PathVariable(name = "bookId") Long bookId,
                                                       HttpServletRequest request) {
        var book = getBookUseCase.getById(bookId);
        var geBookOutputDTO = converter.toBookOutputDTO(book);

        return sendOkStatus(
                request,
                geBookOutputDTO,
                new Message("key", "Retrivied book")
        );
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<ApiSuccessResponse> put (@PathVariable(name = "bookId") Long bookId,
                                                   @RequestBody UpdateBookInputDTO dto,
                                                   HttpServletRequest request) {
        dto.setIsbn(bookId);
        var book = updateBookUseCase.update(dto);
        var bookOutputDTO = converter.toBookOutputDTO(book);
        return sendOkStatus(
                request,
                bookOutputDTO,
                new Message("key", "Updated book")
        );
    }

    @PatchMapping("/{bookId}")
    public ResponseEntity<ApiSuccessResponse> patch (@PathVariable(name = "bookId") Long bookId,
                                                     @RequestBody UpdateBookInputDTO dto,
                                                     HttpServletRequest request) {
        dto.setIsbn(bookId);
        var book = partialUpdateBookUseCase.partialUpdate(dto);
        var bookOutputDTO = converter.toBookOutputDTO(book);
        return sendOkStatus(
                request,
                bookOutputDTO,
                new Message("key", "Updated book")
        );
    }
}
