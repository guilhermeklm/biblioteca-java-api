package com.karam.librarymanagement.domain.specification;

import java.util.ArrayList;
import java.util.List;

public abstract class SpecificationValidation<T> {

    private List<String> errorMessages;

    public SpecificationValidation() {
        this.errorMessages = new ArrayList<>();
    }

    abstract boolean isSatisfied(T entity);

    abstract void setNext(T entity);

    protected void addErrorMessage(String message) {
        this.errorMessages.add(message);
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
