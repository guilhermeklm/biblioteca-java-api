package com.karam.librarymanagement.domain;

import com.karam.librarymanagement.domain.exception.FieldIsRequiredException;

public class Book extends DomainValidation {

    private Long isbn;
    private String title;
    private Author author;
    private Publisher publisher;
    private String yearPublication;
    private Genre genre;

    private Book(Long isbn, String title, Author author, Publisher publisher, String yearPublication, Genre genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublication = yearPublication;
        this.genre = genre;
        this.validate();
    }

    private void validate() {
        if (this.isNull(title)) {
            throw new FieldIsRequiredException("Campo 'title' esta nulo");
        }

        if (this.isNull(yearPublication)) {
            throw new FieldIsRequiredException("Campo 'yearPublication' esta nulo");
        }

//        if (this.isNull(genreId)) {
//            throw new FieldIsRequiredException("Campo 'genreId' esta nulo ou o valor é incorreto");
//        }
    }

    public Long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Long getAuthorId() {
        return this.getAuthor().getId();
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Long getPublisherId() {
        return this.getPublisher().getId();
    }

    public String getYearPublication() {
        return yearPublication;
    }

    public Genre getGenre() {
        return genre;
    }
    public Long getGenreId() {
        return this.getGenre().getId();
    }

    public static class Builder {
        private Long isbn;
        private String title;
        private Author author;
        private Publisher publisher;
        private String yearPublication;
        private Genre genre;

        public Builder() {}

        public Builder isbn(Long isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(Author author) {
            this.author = author;
            return this;
        }

        public Builder publisher(Publisher publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder yearPublication(String yearPublication) {
            this.yearPublication = yearPublication;
            return this;
        }

        public Builder genre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Book build() {
            return new Book(
                    this.isbn,
                    this.title,
                    this.author,
                    this.publisher,
                    this.yearPublication,
                    this.genre
            );
        }
    }
}
