package com.karam.librarymanagement.infraestructure.repository.book;

import com.karam.librarymanagement.infraestructure.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
}
