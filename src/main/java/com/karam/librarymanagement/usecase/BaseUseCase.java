package com.karam.librarymanagement.usecase;

import com.karam.librarymanagement.domain.Domain;
import com.karam.librarymanagement.domain.specification.SpecificationTemplate;

public abstract class BaseUseCase<D extends Domain, InputDTO> {

    private Converter<D, InputDTO> converter;

    private SpecificationTemplate<D> specification;

    public BaseUseCase(Converter<D, InputDTO> converter,
                       SpecificationTemplate<D> specification) {
        this.converter = converter;
        this.specification = specification;
    }

    public Converter<D, InputDTO> getConverter() {
        return converter;
    }

    public SpecificationTemplate<D> getSpecification() {
        return specification;
    }
}
