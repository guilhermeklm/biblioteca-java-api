package com.karam.librarymanagement.infraestructure.repository.author;

import com.karam.librarymanagement.infraestructure.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorJpaRepository extends JpaRepository<AuthorEntity, Long> {

    @Query(value = "select aut_id from biblioteca.autor where " +
            "aut_nome = :name and " +
            "aut_origem = :country", nativeQuery = true)
    Long findIdByAuthor(@Param("name") String name,
                        @Param("country") String country);
}
