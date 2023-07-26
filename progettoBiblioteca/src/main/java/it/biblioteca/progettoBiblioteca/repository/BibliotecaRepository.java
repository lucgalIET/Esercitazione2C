package it.biblioteca.progettoBiblioteca.repository;

import it.biblioteca.progettoBiblioteca.entities.BibliotecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface BibliotecaRepository  extends JpaRepository<BibliotecaEntity, Long> {

    @Query(value = "SELECT b.nome, l.titolo " +
            "FROM libro l , biblioteca b " +
            "WHERE l.id= :idLibro AND b.id=l.biblioteca_fk", nativeQuery = true)
    List<String> getTitoloLibroNomeBiblioteca(@Param("idLibro") Integer idLibro);
}
