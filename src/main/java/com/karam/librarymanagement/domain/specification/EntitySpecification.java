package com.karam.librarymanagement.domain.specification;

import com.karam.librarymanagement.domain.Domain;

import java.util.Objects;

public abstract class EntitySpecification<D extends Domain> {

    private String errorMessage;

    public abstract void validate(D entity);

    protected void addErrorMessage(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean hasErrorMessage() {
        return Objects.nonNull(this.errorMessage);
    }
}
