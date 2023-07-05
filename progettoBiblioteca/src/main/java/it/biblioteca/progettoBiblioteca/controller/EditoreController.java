package it.biblioteca.progettoBiblioteca.controller;

import it.biblioteca.progettoBiblioteca.entities.EditoreEntity;
import it.biblioteca.progettoBiblioteca.service.EditoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/editore")
public class EditoreController {

    @Autowired
    private EditoreService editoreService;

    @PostMapping("/salva-editore")
    public EditoreEntity saveEditore(@RequestBody EditoreEntity editoreEntity){
        return editoreService.saveEditore(editoreEntity);
    }

    @GetMapping("/editori")
    public List<EditoreEntity> getEditori(){
        return editoreService.getEditori();
    }

    @GetMapping("/{id}")
    public Optional<EditoreEntity> getEditoreById(@PathVariable Long id){
        return editoreService.getEditoreById(id);
    }

    @PutMapping("/update-editore")
    public EditoreEntity updateEditore(@RequestBody EditoreEntity editoreEntity){
        return editoreService.updateEditore(editoreEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteEditore(@PathVariable Long id){
        editoreService.deleteEditore(id);
    }
}
