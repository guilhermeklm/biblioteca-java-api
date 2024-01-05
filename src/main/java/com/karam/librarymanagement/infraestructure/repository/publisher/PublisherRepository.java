package com.karam.librarymanagement.infraestructure.repository.publisher;

import com.karam.librarymanagement.domain.Publisher;

public interface PublisherRepository {

    Publisher save(Publisher publisher);

    Publisher findById(Long id);

    Long findIdByName(String name);
}
