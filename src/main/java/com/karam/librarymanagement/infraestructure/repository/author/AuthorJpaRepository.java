package com.karam.librarymanagement.infraestructure.repository.author;

import com.karam.librarymanagement.infraestructure.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorJpaRepository extends JpaRepository<AuthorEntity, Long> {
}
