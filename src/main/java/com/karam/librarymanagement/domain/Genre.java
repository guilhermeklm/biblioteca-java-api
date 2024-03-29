package com.karam.librarymanagement.domain;

import com.karam.librarymanagement.domain.exception.FieldIsRequiredException;

import java.util.Objects;

public class Genre extends Domain {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre genre)) return false;
        return Objects.equals(getId(), genre.getId()) && Objects.equals(getName(), genre.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
