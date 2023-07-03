package it.biblioteca.progettoBiblioteca.service;

import it.biblioteca.progettoBiblioteca.entities.AutoreEntity;
import it.biblioteca.progettoBiblioteca.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    public AutoreEntity saveAutore(AutoreEntity autoreEntity){
        return autoreRepository.save(autoreEntity);
    }

    public List<AutoreEntity> getAllAutori(){
        return autoreRepository.findAll();
    }

    public Optional<AutoreEntity> getAutoreById(Long id){
        return autoreRepository.findById(id);
    }

    public AutoreEntity updateAutore(AutoreEntity autoreEntityNew){
        Optional<AutoreEntity> autoreEntity = getAutoreById(autoreEntityNew.getId());
        if(autoreEntity.isEmpty()) throw new NullPointerException();
        return autoreRepository.save(autoreEntityNew);
    }

    public void deleteAutore(Long id){
        autoreRepository.deleteById(id);
    }





}
