package it.biblioteca.progettoBiblioteca;

import it.biblioteca.progettoBiblioteca.entities.AutoreEntity;
import it.biblioteca.progettoBiblioteca.entities.LibroEntity;
import it.biblioteca.progettoBiblioteca.repository.AutoreRepository;
import it.biblioteca.progettoBiblioteca.service.AutoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AutoreTest1 {

    @Autowired
    private AutoreService autoreService;

    @MockBean
    private AutoreRepository autoreRepository;

    @Test
    public void autoreFindAll(){

        AutoreEntity autore1= new AutoreEntity();
        autore1.setId(1L);
        autore1.setNome("Paolo");
        autore1.setCognome("Conte");
        autore1.setDataDiNascita("03/04/1987");
        autore1.setNazione("Italia");
        autore1.setListaLibri(new LibroEntity(1L, "Harry Potter", "2233", "fantasy",1));
    }
}
