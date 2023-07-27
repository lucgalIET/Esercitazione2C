package it.biblioteca.progettoBiblioteca.controller;

import it.biblioteca.progettoBiblioteca.dto.BibliotecaDTO;
import it.biblioteca.progettoBiblioteca.entities.BibliotecaEntity;
import it.biblioteca.progettoBiblioteca.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/biblioteca")
@CrossOrigin(origins = "**")
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

    @PutMapping("/update-biblioteca")
    public BibliotecaEntity updateBiblioteca(@RequestBody BibliotecaEntity bibliotecaEntity){
        return bibliotecaService.updateBiblioteca(bibliotecaEntity);
    }

    @DeleteMapping("/delete-biblioteca/{id}")
    public void deleteBiblioteca(@PathVariable Long id){
        bibliotecaService.deleteBiblioteca(id);
    }

    @GetMapping("/titolo-libro-biblioteca/{idLibro}")
    public List<String> getTitoloLibroNomeBiblioteca(@PathVariable Long idLibro){
        return bibliotecaService.getTitoloLibroNomeBiblioteca(idLibro);
    }

    //CRUD DTO

    @PostMapping("/save-bibliotecadto")
    public BibliotecaEntity saveBibliotecaDTO(@RequestBody BibliotecaDTO bibliotecaDTO){
        return bibliotecaService.saveBibliotecaDTO(bibliotecaDTO);
    }

    @GetMapping("/bibliotechedto")
    public List<BibliotecaDTO> getBibliotecheDTO(){
        return bibliotecaService.getBibliotecheDTO();
    }

    @GetMapping("/bibliotecadto/{id}")
    public BibliotecaDTO getBibliotecaDTOById(@PathVariable Long id){
        return bibliotecaService.getBibliotecaDTOById(id);
    }
}
