package com.karam.librarymanagement.infraestructure.repository.publisher;

import com.karam.librarymanagement.infraestructure.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherJpaRepository extends JpaRepository<PublisherEntity, Long> {

    @Query(value = "select edi_id from biblioteca.editora where " +
            "edi_nome = :name", nativeQuery = true)
    Long findIdByName(@Param("name") String name);
}
