package it.biblioteca.progettoBiblioteca.repository;

import it.biblioteca.progettoBiblioteca.entities.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
}
