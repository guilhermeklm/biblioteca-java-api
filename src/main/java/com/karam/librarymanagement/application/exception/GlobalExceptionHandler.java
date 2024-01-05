package com.karam.librarymanagement.application.exception;

import com.karam.librarymanagement.application.dto.response.ApiErrorResponse;
import com.karam.librarymanagement.application.dto.response.LinksResponse;
import com.karam.librarymanagement.application.dto.response.Message;
import com.karam.librarymanagement.domain.exception.BusinessException;
import com.karam.librarymanagement.infraestructure.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorResponse> businessError(final BusinessException exception) {
        var messages = new ArrayList<Message>();

        exception.getMessages().forEach(message -> {
            messages.add(new Message("key", message));
        });

        var apiErrorResponse = new ApiErrorResponse(
                exception.getStatusCode(),
                new LinksResponse("/books", "POST"),
                messages
        );

        return ResponseEntity.status(exception.getStatusCode()).body(apiErrorResponse);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> entityNotFoundError(final EntityNotFoundException exception) {
        // Como pegar o href da request e o method
        var apiErrorResponse = new ApiErrorResponse(
                exception.getStatusCode(),
                new LinksResponse("/books", "POST"),
                List.of(new Message("key", exception.getMessage()))
        );
        return ResponseEntity.status(exception.getStatusCode()).body(apiErrorResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> runtimeException(final RuntimeException exception) {
        var apiErrorResponse = new ApiErrorResponse(
                500,
                new LinksResponse("/books", "POST"),
                List.of(new Message("key", exception.getMessage()))
        );
        return ResponseEntity.status(500).body(apiErrorResponse);
    }
}
