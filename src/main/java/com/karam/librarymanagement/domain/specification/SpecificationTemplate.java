package com.karam.librarymanagement.domain.specification;

import com.karam.librarymanagement.domain.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

public abstract class SpecificationTemplate<T> {

    private List<EntitySpecification<T>> entitySpecifications;

    private List<String> errorMessages;

    public void validate(T entity) {
        this.initializateErrorMessages();
        this.addSpecifications();

        this.validateSpecifications(entity);

        try {
            if (this.hasErrorMessages()) {
                throw new BusinessException(this.getErrorMessages());
            }
        } finally {
            this.clearSpecifications();
            this.clearErrorMessages();
        }
    }

    protected abstract void addSpecifications();

    private void validateSpecifications(T entity) {
        this.entitySpecifications.forEach(specification -> {
            specification.validate(entity);

            if (specification.hasErrorMessage()) {
                this.errorMessages.add(specification.getErrorMessage());
            }
        });
    }

    private void clearSpecifications() {
        this.entitySpecifications = null;
    }

    private void clearErrorMessages() {
        this.errorMessages = null;
    }

    protected void setEntitySpecifications(List<EntitySpecification<T>> entitySpecifications) {
        this.entitySpecifications = entitySpecifications;
    }

    private void initializateErrorMessages() {
        this.errorMessages = new ArrayList<>();
    }

    private List<String> getErrorMessages() {
        return errorMessages;
    }

    private boolean hasErrorMessages() {
        return !this.errorMessages.isEmpty();
    }
}
