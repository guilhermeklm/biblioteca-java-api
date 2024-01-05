package com.karam.librarymanagement.domain.specification;

import java.util.Objects;

public abstract class EntitySpecification<T> {

    private String errorMessage;

    public abstract void validate(T entity);

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
