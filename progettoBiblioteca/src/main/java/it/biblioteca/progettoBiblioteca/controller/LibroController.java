package it.biblioteca.progettoBiblioteca.controller;


import it.biblioteca.progettoBiblioteca.entities.LibroEntity;
import it.biblioteca.progettoBiblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/libro")
public class LibroController {


    @Autowired
    private LibroService libroService;

    @PostMapping("/salva-libro")
    public LibroEntity saveLibro(@RequestBody LibroEntity libroEntity){
        return libroService.saveLibro(libroEntity);
    }

    @GetMapping("/libri")
    public List<LibroEntity> getLibri(){
        return libroService.getLibri();
    }

    @GetMapping("/libri/{id}")
    public Optional<LibroEntity> getLibroById(@PathVariable Long id){
        return libroService.getLibroById(id);
    }

    @PutMapping("/update-libro")
    public LibroEntity updateLibro(@RequestBody LibroEntity libroEntity){
        return libroService.updateLibro(libroEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id){
        libroService.deleteLibro(id);
    }
}
