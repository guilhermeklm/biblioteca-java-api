package com.karam.librarymanagement.application.dto;

public class CreateBookInputDTO extends InputDTO {

    private String title;
    private Long authorId;
    private Long publisherId;
    private String yearPublication;
    private Long genreId;

    public CreateBookInputDTO(String title, Long authorId, Long publisherId, String yearPublication, Long genreId) {
        this.title = title;
        this.authorId = authorId;
        this.publisherId = publisherId;
        this.yearPublication = yearPublication;
        this.genreId = genreId;
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
