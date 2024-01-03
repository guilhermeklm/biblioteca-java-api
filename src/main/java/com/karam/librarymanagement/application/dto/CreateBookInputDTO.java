package com.karam.librarymanagement.application.dto;

import java.time.LocalDate;

public record CreateBookInputDTO(
        String title,
        Long authorId,
        Long publisherId,
        String yearPublication,
        Long genreId) {
}
