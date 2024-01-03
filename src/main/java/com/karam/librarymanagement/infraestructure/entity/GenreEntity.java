package com.karam.librarymanagement.infraestructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "genero")
public class GenreEntity {

    @Id
    @Column(name = "gen_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gen_nome")
    private String nome;

    @Deprecated
    public GenreEntity() {
    }

    public GenreEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
