package it.biblioteca.progettoBiblioteca.repository;

import it.biblioteca.progettoBiblioteca.entities.AutoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoreRepository extends JpaRepository<AutoreEntity, Long> {

    @Query(value = "SELECT *"+
    "FROM autore a"+
    "WHERE a.id > :id", nativeQuery = true)
    List<AutoreEntity> getAutoriListDaID(@Param("id") Long id);



}
