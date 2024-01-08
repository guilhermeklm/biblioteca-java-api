package com.karam.librarymanagement.domain;

import com.karam.librarymanagement.domain.exception.FieldIsRequiredException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book extends Domain {

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
    }

    @Override
    public Long getId() {
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

    public List<String> modifiedFields(Book newBook, Book oldBook) {
        List<String> modifiedFieldsList = new ArrayList<>();
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                if ("isbn".equals(field.getName())) {
                    continue;
                }

                Object newValue = field.get(newBook);
                Object oldValue = field.get(oldBook);

                if ((newValue == null && oldValue != null) || (newValue != null && !newValue.equals(oldValue))) {
                    modifiedFieldsList.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Erro ao listar campos alterados");
            }
        }
        return modifiedFieldsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getId(), book.getId()) &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getPublisher(), book.getPublisher()) &&
                Objects.equals(getYearPublication(), book.getYearPublication()) &&
                Objects.equals(getGenre(), book.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getAuthor(), getPublisher(), getYearPublication(), getGenre());
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
