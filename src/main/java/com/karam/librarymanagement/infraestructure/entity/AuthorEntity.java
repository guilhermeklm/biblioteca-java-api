package com.karam.librarymanagement.infraestructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "autor")
public class AuthorEntity {

    @Id
    @Column(name = "aut_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aut_nome")
    private String name;

    @Column(name = "aut_origem")
    private String country;

    @Deprecated
    public AuthorEntity() {
    }

    public AuthorEntity(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
