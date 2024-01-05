package com.karam.librarymanagement.domain;

import com.karam.librarymanagement.domain.exception.FieldIsRequiredException;

public class Genre extends DomainValidation {

    private Long id;

    private String name;

    private Genre(Long id, String name) {
        this.id = id;
        this.name = name;
        this.validate();
    }

    public static Genre createGenre(Long id, String name) {
        return new Genre(id, name);
    }

    private void validate() {
        if (this.isNull(this.name)) {
            throw new FieldIsRequiredException("Campo 'name' esta nulo ou o valor é incorreto");
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
