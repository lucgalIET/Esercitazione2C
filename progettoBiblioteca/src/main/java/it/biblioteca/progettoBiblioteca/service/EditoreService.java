package it.biblioteca.progettoBiblioteca.service;

import it.biblioteca.progettoBiblioteca.entities.EditoreEntity;
import it.biblioteca.progettoBiblioteca.repository.EditoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoreService {

    @Autowired
    private EditoreRepository editoreRepository;

    public EditoreEntity saveEditore(EditoreEntity editoreEntity){
        return editoreRepository.save(editoreEntity);
    }

    public List<EditoreEntity> getEditori(){
        return editoreRepository.findAll();
    }

    public Optional<EditoreEntity> getEditoreById(Long id){
        return editoreRepository.findById(id);
    }

    public EditoreEntity updateEditore(EditoreEntity editoreEntityNew){
        Optional<EditoreEntity> editoreEntity = getEditoreById(editoreEntityNew.getId());
        if(editoreEntity.isEmpty()) throw new NullPointerException();
        return editoreEntityNew;
    }

    public void deleteEditore(Long id){
        editoreRepository.deleteById(id);
    }
}
