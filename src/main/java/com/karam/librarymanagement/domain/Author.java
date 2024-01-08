package com.karam.librarymanagement.domain;

import com.karam.librarymanagement.domain.exception.FieldIsRequiredException;

import java.util.Objects;

public class Author extends Domain {
    private Long id;
    private String name;
    private String country;

    private Author(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.validate();
    }

    private void validate() {
        if (this.isNull(this.name)) {
            throw new FieldIsRequiredException("Campo 'name' esta nulo ou o valor é incorreto");
        }

        if (this.isNull(this.country)) {
            throw new FieldIsRequiredException("Campo 'country' esta nulo ou o valor é incorreto");
        }
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(getId(), author.getId()) &&
                Objects.equals(getName(), author.getName()) &&
                Objects.equals(getCountry(), author.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCountry());
    }

    public static class Builder {
        private Long id;
        private String name;
        private String country;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Author build() {
            return new Author(
                    this.id,
                    this.name,
                    this.country
            );
        }
    }
}


