package com.karam.librarymanagement.domain.specification;

import com.karam.librarymanagement.domain.Domain;

import java.util.Objects;

public abstract class EntitySpecification<D extends Domain> {

    private final D domain;
    private String errorMessage;

    public EntitySpecification(D domain) {
        this.domain = domain;
    }

    public abstract void validate();

    protected void addErrorMessage(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean hasErrorMessage() {
        return Objects.nonNull(this.errorMessage);
    }

    public D getDomain() {
        return domain;
    }
}
