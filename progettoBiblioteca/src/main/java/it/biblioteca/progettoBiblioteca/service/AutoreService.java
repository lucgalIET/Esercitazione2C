package it.biblioteca.progettoBiblioteca.service;

import it.biblioteca.progettoBiblioteca.dto.AutoreDTO;
import it.biblioteca.progettoBiblioteca.entities.AutoreEntity;
import it.biblioteca.progettoBiblioteca.mapper.AutoreMapper;
import it.biblioteca.progettoBiblioteca.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

    public List<AutoreEntity> getAutoriListDaID(Long id){
        return autoreRepository.getAutoriListDaID(id);
    }


    public List<AutoreDTO> getAutoreDTO() {
        List<AutoreEntity> listaAutori = autoreRepository.findAll();
        List<AutoreDTO> listaDTO = new ArrayList<>();
        for (AutoreEntity l : listaAutori) {
            listaDTO.add(AutoreMapper.AUTORE_MAPPER.entityToDTO(l));
        }
        return listaDTO;
    }

    public AutoreDTO getAutoreDTOById(Long id){
        Optional<AutoreEntity> autoreEntity = getAutoreById(id);
        return autoreEntity.map(AutoreMapper.AUTORE_MAPPER::entityToDTO).orElse(null);
    }

    public AutoreDTO saveAutoreDTO(AutoreDTO autoreDTO){
        return AutoreMapper.AUTORE_MAPPER.entityToDTO(autoreRepository.save(AutoreMapper.AUTORE_MAPPER.dtoToEntity(autoreDTO)));
    }

    public AutoreDTO updateAutoreDTO(AutoreDTO autoreDTONew){
        Optional<AutoreEntity> autoreEntity = getAutoreById(autoreDTONew.getId());
        if(autoreEntity.isEmpty()) throw new NullPointerException();
        return autoreDTONew;
    }




}
