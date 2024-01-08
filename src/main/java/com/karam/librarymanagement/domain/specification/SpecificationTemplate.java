package com.karam.librarymanagement.domain.specification;

import com.karam.librarymanagement.domain.Domain;
import com.karam.librarymanagement.domain.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

public abstract class SpecificationTemplate<D extends Domain> {

    private List<EntitySpecification<D>> entitySpecifications;

    private List<String> errorMessages;

    public void validate(D entity) {
        this.initializateErrorMessages();
        this.addSpecifications(entity);

        this.validateSpecifications();

        try {
            if (this.hasErrorMessages()) {
                throw new BusinessException(this.getErrorMessages());
            }
        } finally {
            this.clearSpecifications();
            this.clearErrorMessages();
        }
    }

    protected abstract void addSpecifications(D entity);

    private void validateSpecifications() {
        this.entitySpecifications.forEach(specification -> {
            specification.validate();

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

    protected void setEntitySpecifications(List<EntitySpecification<D>> entitySpecifications) {
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
