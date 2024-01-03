package com.karam.librarymanagement.infraestructure.repository.publisher;

import com.karam.librarymanagement.infraestructure.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherJpaRepository extends JpaRepository<PublisherEntity, Long> {
}
