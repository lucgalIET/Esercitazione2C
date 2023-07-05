package it.biblioteca.progettoBiblioteca;

import it.biblioteca.progettoBiblioteca.controller.AutoreController;
import it.biblioteca.progettoBiblioteca.entities.AutoreEntity;
import it.biblioteca.progettoBiblioteca.entities.EditoreEntity;
import it.biblioteca.progettoBiblioteca.service.AutoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AutoreControllerTest {

    @MockBean
    private AutoreService service;

    @InjectMocks
    private AutoreController controller;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveAutore(){

        AutoreEntity autore= new AutoreEntity(1L,"Paolo","Rossi","03/04/2000","Italia", new ArrayList<>(),new EditoreEntity());
        when(service.saveAutore(any(AutoreEntity.class))).thenReturn(autore);

        AutoreEntity result= controller.saveAutore(autore);

        assertEquals(autore, result);
    }

    @Test
    void autoriFindAll(){

        List<AutoreEntity> autoreEntityList= new ArrayList<>();
        autoreEntityList.add(new AutoreEntity(1L,"Paolo","Rossi","03/04/2000","Italia", new ArrayList<>(),new EditoreEntity()));
        autoreEntityList.add(new AutoreEntity(2L,"Mario","Verdi","04/07/2002","Francia", new ArrayList<>(),new EditoreEntity()));

        when(service.getAllAutori()).thenReturn(autoreEntityList);

        List<AutoreEntity> result= controller.getAllAutori();

        assertEquals(autoreEntityList, result );
    }
    @Test
    void autoreFindById(){
        AutoreEntity autore=new AutoreEntity(1L,"Paolo","Rossi","03/04/2000","Italia", new ArrayList<>(),new EditoreEntity());

        when(service.getAutoreById(1L)).thenReturn(Optional.of(autore));

        Optional<AutoreEntity> result= controller.getAutoreById(1L);

        assertEquals(Optional.of(autore), result);
    }

    @Test
    void deleteAutore(){
        Long id= 1L;

        controller.deleteAutore(id);
        verify(service, times(1)).deleteAutore(id);
    }

    @Test
    void queryAutore(){
        List<AutoreEntity> autoreEntityList= new ArrayList<>();
        autoreEntityList.add(new AutoreEntity(1L,"Paolo","Rossi","03/04/2000","Italia", new ArrayList<>(),new EditoreEntity()));
        autoreEntityList.add(new AutoreEntity(2L,"Mario","Verdi","04/07/2002","Francia", new ArrayList<>(),new EditoreEntity()));

        when(service.getAutoriListDaID(1L)).thenReturn(autoreEntityList);

        List<AutoreEntity> result= controller.getAutoriListDaID(1L);

        assertEquals(autoreEntityList, result );

    }
}
