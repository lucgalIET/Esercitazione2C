package it.biblioteca.progettoBiblioteca.service;

import it.biblioteca.progettoBiblioteca.entities.BibliotecaEntity;
import it.biblioteca.progettoBiblioteca.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public List<BibliotecaEntity> getBiblioteche(){
        return bibliotecaRepository.findAll();
    }

    public Optional<BibliotecaEntity> getBibliotecaById(Long id){
        return bibliotecaRepository.findById(id);
    }

    public BibliotecaEntity saveBiblioteca(BibliotecaEntity bibliotecaEntity){
        return bibliotecaRepository.save(bibliotecaEntity);
    }

    public BibliotecaEntity updateBiblioteca(BibliotecaEntity bibliotecaNew){
        Optional<BibliotecaEntity> bibliotecaEntity = getBibliotecaById(bibliotecaNew.getIdBiblioteca());

        if(bibliotecaEntity.isEmpty()) throw new NullPointerException();

        return bibliotecaRepository.save(bibliotecaNew);
    }

    public void deleteBiblioteca(Long id){
        bibliotecaRepository.deleteById(id);
    }
}
