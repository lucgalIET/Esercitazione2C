package it.biblioteca.progettoBiblioteca.repository;

import it.biblioteca.progettoBiblioteca.entities.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {

    @Query(value = "SELECT * "+
            "FROM libro l "+
            "WHERE l.biblioteca_fk = :id", nativeQuery = true)
    List<LibroEntity> getLibriByBiliotecaId(@Param("id") Long id);
}
