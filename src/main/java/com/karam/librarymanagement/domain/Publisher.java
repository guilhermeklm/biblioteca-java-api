package com.karam.librarymanagement.domain;

import com.karam.librarymanagement.domain.exception.FieldIsRequiredException;

import java.util.Objects;

public class Publisher extends Domain {

    private Long id;

    private String name;

    private Publisher(Long id, String name) {
        this.id = id;
        this.name = name;
        this.validate();
    }

    public static Publisher createPublisher(Long id, String name) {
        return new Publisher(id, name);
    }

    public static Publisher createPublisher(String name) {
        return new Publisher(null, name);
    }

    private void validate() {
        if (this.isNull(this.name)) {
            throw new FieldIsRequiredException("Campo 'name' esta nulo ou o valor é incorreto");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher publisher)) return false;
        return Objects.equals(getId(), publisher.getId()) && Objects.equals(getName(), publisher.getName());
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
