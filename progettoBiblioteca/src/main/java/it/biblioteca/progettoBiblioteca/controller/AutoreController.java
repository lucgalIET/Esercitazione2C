package it.biblioteca.progettoBiblioteca.controller;

import it.biblioteca.progettoBiblioteca.dto.AutoreDTO;
import it.biblioteca.progettoBiblioteca.entities.AutoreEntity;
import it.biblioteca.progettoBiblioteca.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autore")
@CrossOrigin(origins = "**")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping("/salva-autore")
    public AutoreEntity saveAutore(@RequestBody AutoreEntity autoreEntity){
        return autoreService.saveAutore(autoreEntity);
    }

    @GetMapping("/autori")
    public List<AutoreEntity> getAllAutori(){
        return autoreService.getAllAutori();
    }

    @GetMapping("/autori/{id}")
    public Optional<AutoreEntity> getAutoreById(@PathVariable Long id){
        return autoreService.getAutoreById(id);
    }

    @PutMapping("/update-autore")
    public AutoreEntity updateAutore(@RequestBody AutoreEntity autoreEntity){
        return autoreService.updateAutore(autoreEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteAutore(@PathVariable Long id){
        autoreService.deleteAutore(id);
    }

    @GetMapping("/autori-da/{id}")
    public List<AutoreEntity> getAutoriListDaID(@PathVariable Long id){
        return autoreService.getAutoriListDaID(id);
    }

    @GetMapping("/autoriDTO")
    public List<AutoreDTO> getAutoriDTO(){
        return autoreService.getAutoreDTO();
    }

    @GetMapping("/DTO/{id}")
    public AutoreDTO getDTOById(@PathVariable Long id){
        return autoreService.getAutoreDTOById(id);
    }

    @PostMapping("/saveDTO")
    public AutoreDTO saveAutoreDTO(@RequestBody AutoreDTO autoreDTO){
        return autoreService.saveAutoreDTO(autoreDTO);
    }

    @PutMapping("/updateDTO")
    public AutoreDTO updateDTO(@RequestBody AutoreDTO autoreDTO){
        return autoreService.updateAutoreDTO(autoreDTO);
    }
}
