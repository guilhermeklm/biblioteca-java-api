package com.karam.librarymanagement.infraestructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "livro", schema = "biblioteca")
public class BookEntity {

    @Id
    @Column(name = "lvr_isbn")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long isbn;

    @Column(name = "lvr_titulo")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lvr_autorid", referencedColumnName = "aut_id")
    private AuthorEntity author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lvr_editoraid", referencedColumnName = "edi_id")
    private PublisherEntity publisher;

    @Column(name = "lvr_anopublicacao")
    private String yearPublication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lvr_generoid", referencedColumnName = "gen_id")
    private GenreEntity genre;

    @Deprecated
    public BookEntity() {
    }

    public BookEntity(Long isbn, String title, AuthorEntity author,
                      PublisherEntity publisher, String yearPublication, GenreEntity genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublication = yearPublication;
        this.genre = genre;
    }

    public Long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public Long getAuthorId() {
        return getAuthor().getId();
    }

    public PublisherEntity getPublisher() {
        return publisher;
    }

    public Long getPublisherId() {
        return getPublisher().getId();
    }

    public String getYearPublication() {
        return yearPublication;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public Long getGenreId() {
        return getGenre().getId();
    }
}
