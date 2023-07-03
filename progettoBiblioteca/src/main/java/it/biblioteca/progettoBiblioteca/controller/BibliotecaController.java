package it.biblioteca.progettoBiblioteca.controller;

import it.biblioteca.progettoBiblioteca.entities.BibliotecaEntity;
import it.biblioteca.progettoBiblioteca.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping("/salva-biblioteca")
    public BibliotecaEntity saveBiblioteca(@RequestBody BibliotecaEntity entity){
        return bibliotecaService.saveBiblioteca(entity);
    }

    @GetMapping("/biblioteche")
    public List<BibliotecaEntity> getBiblioteche(){
        return  bibliotecaService.getBiblioteche();
    }

    @GetMapping("/{id}")
    public Optional<BibliotecaEntity> getBibliotecaById(@PathVariable Long id){
        return bibliotecaService.getBibliotecaById(id);
    }

    @GetMapping("/update-biblioteca")
    public BibliotecaEntity updateBiblioteca(@RequestBody BibliotecaEntity bibliotecaEntity){
        return bibliotecaService.updateBiblioteca(bibliotecaEntity);
    }

    @GetMapping("/delete-biblioteca/{id}")
    public void deleteBiblioteca(@PathVariable Long id){
        bibliotecaService.deleteBiblioteca(id);
    }

    @GetMapping("/titolo-libro-biblioteca/{idLibro}")
    public List<String> getTitoloLibroNomeBiblioteca(@PathVariable Long idLibro){
        return bibliotecaService.getTitoloLibroNomeBiblioteca(idLibro);
    }
}
