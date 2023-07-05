package it.biblioteca.progettoBiblioteca;

import it.biblioteca.progettoBiblioteca.entities.AutoreEntity;
import it.biblioteca.progettoBiblioteca.repository.AutoreRepository;
import it.biblioteca.progettoBiblioteca.service.AutoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

        AutoreEntity autore2= new AutoreEntity();
        autore2.setId(2L);
        autore2.setNome("Mario");
        autore2.setCognome("Rossi");
        autore2.setDataDiNascita("02/01/1990");
        autore2.setNazione("Francia");

        List<AutoreEntity> autoreEntityList= Arrays.asList(autore1,autore2);

        when(autoreRepository.findAll()).thenReturn(autoreEntityList);

        List<AutoreEntity> result = autoreService.getAllAutori();

        assertEquals(2, result.size());
        assertEquals("Paolo", result.get(0).getNome());
        assertEquals("Francia",result.get(1).getNazione());
    }
}

