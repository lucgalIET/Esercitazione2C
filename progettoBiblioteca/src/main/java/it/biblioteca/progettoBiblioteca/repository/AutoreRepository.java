package it.biblioteca.progettoBiblioteca.repository;

import it.biblioteca.progettoBiblioteca.entities.AutoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AutoreRepository extends JpaRepository<AutoreEntity, Long> {
}
