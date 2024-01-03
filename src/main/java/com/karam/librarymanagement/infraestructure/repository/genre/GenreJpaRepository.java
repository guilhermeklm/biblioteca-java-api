package com.karam.librarymanagement.infraestructure.repository.genre;

import com.karam.librarymanagement.infraestructure.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreJpaRepository extends JpaRepository<GenreEntity, Long> {
}
