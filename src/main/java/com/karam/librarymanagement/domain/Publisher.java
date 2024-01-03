package com.karam.librarymanagement.domain;

import com.karam.librarymanagement.domain.exception.FieldIsRequiredException;

public class Publisher extends DomainValidation {

    private Long id;

    private String name;

    public Publisher(Long id, String name) {
        this.id = id;
        this.name = name;
        this.validate();
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
