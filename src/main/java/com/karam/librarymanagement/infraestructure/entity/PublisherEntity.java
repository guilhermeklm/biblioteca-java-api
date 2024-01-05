package com.karam.librarymanagement.infraestructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "editora", schema = "biblioteca")
public class PublisherEntity {

    @Id
    @Column(name = "edi_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "edi_nome")
    private String name;

    @Deprecated
    public PublisherEntity() {
    }

    public PublisherEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
