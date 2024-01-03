package com.karam.librarymanagement.infraestructure.repository.publisher;

import com.karam.librarymanagement.domain.Publisher;

public interface PublisherRepository {

    Publisher findById(Long id);
}
