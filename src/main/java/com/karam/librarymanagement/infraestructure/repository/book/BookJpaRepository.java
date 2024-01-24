package com.karam.librarymanagement.infraestructure.repository.book;

import com.karam.librarymanagement.infraestructure.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {

    @Query(value = "select lvr_isbn from biblioteca.livro where " +
            "lvr_titulo = :title and " +
            "lvr_autorid = :authorId and " +
            "lvr_editoraid = :publisherId and " +
            "lvr_anopublicacao = :yearPublication and " +
            "lvr_generoid = :genreId", nativeQuery = true)
    Long findIdByBook(@Param("title") String title,
                        @Param("authorId") Long authorId,
                        @Param("publisherId") Long publisherId,
                        @Param("yearPublication") String yearPublication,
                        @Param("genreId") Long genreId);


    @Query(value = "select lvr_isbn from biblioteca.livro where " +
            "lvr_titulo = :title", nativeQuery = true)
    Long findIdByTitle(@Param("title") String title);

    @Query(value = "select count(lvr_isbn) from biblioteca.livro where lvr_autorid = :authorId",
            nativeQuery = true)
    long countByAuthorId(@Param("authorId") long authorId);
}
