package it.biblioteca.progettoBiblioteca.service;

import it.biblioteca.progettoBiblioteca.entities.LibroEntity;
import it.biblioteca.progettoBiblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public LibroEntity saveLibro(LibroEntity libroEntity){
        return libroRepository.save(libroEntity);
    }

    public List<LibroEntity> getLibri(){
        return libroRepository.findAll();
    }

    public Optional<LibroEntity> getLibroById(Long id){
        return libroRepository.findById(id);
    }

    public LibroEntity updateLibro(LibroEntity libroNew){
        Optional<LibroEntity> libroEntity = getLibroById(libroNew.getId());
        if(libroEntity.isEmpty()) throw new NullPointerException();

        return libroRepository.save(libroNew);
    }

    public void deleteLibro(Long id){
        libroRepository.deleteById(id);
    }

    public List<LibroEntity> getLibriByBiliotecaId(Long id){
        return libroRepository.getLibriByBiliotecaId(id);
    }
}
