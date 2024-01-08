package com.karam.librarymanagement.application.dto;

public class UpdateBookInputDTO extends InputDTO {

    private Long isbn;
    private String title;
    private Long authorId;
    private Long publisherId;
    private String yearPublication;
    private Long genreId;

    public UpdateBookInputDTO(Long isbn,
                              String title,
                              Long authorId,
                              Long publisherId,
                              String yearPublication,
                              Long genreId
    ) {
        this.isbn = isbn;
        this.title = title;
        this.authorId = authorId;
        this.publisherId = publisherId;
        this.yearPublication = yearPublication;
        this.genreId = genreId;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public String getYearPublication() {
        return yearPublication;
    }

    public Long getGenreId() {
        return genreId;
    }
}
