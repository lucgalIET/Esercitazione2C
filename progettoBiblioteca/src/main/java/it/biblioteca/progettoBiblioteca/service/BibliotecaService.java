package it.biblioteca.progettoBiblioteca.service;

import it.biblioteca.progettoBiblioteca.dto.BibliotecaDTO;
import it.biblioteca.progettoBiblioteca.dto.LibroDTO;
import it.biblioteca.progettoBiblioteca.entities.BibliotecaEntity;
import it.biblioteca.progettoBiblioteca.entities.LibroEntity;
import it.biblioteca.progettoBiblioteca.mapper.BibliotecaMapper;
import it.biblioteca.progettoBiblioteca.mapper.LibroMapper;
import it.biblioteca.progettoBiblioteca.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<String> getTitoloLibroNomeBiblioteca(Long idLibro){
        return bibliotecaRepository.getTitoloLibroNomeBiblioteca(Math.toIntExact(idLibro));
    }

    //CRUD DTO
    public BibliotecaEntity saveBibliotecaDTO(BibliotecaDTO bibliotecaDTO){
        BibliotecaEntity biblioteca= BibliotecaMapper.BIBLIOTECA_MAPPER.dtoToEntity(bibliotecaDTO);

        return bibliotecaRepository.save(biblioteca);
    }


    public List<BibliotecaDTO> getBibliotecheDTO(){
        List<BibliotecaEntity> listaBiblioteche = bibliotecaRepository.findAll();
        List<BibliotecaDTO> listaBibliotecheDTO = new ArrayList<>();
        for(BibliotecaEntity b: listaBiblioteche){
            listaBibliotecheDTO.add(BibliotecaMapper.BIBLIOTECA_MAPPER.entityToDto(b));
        }
        return listaBibliotecheDTO;

    }

    public BibliotecaDTO getBibliotecaDTOById(Long id){
        Optional<BibliotecaEntity> bibliotecaEntity= bibliotecaRepository.findById(id);
        return bibliotecaEntity.map(BibliotecaMapper.BIBLIOTECA_MAPPER::entityToDto).orElse(null);
    }



}
