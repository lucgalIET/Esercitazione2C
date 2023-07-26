package it.biblioteca.progettoBiblioteca.service;

        import it.biblioteca.progettoBiblioteca.dto.EditoreDTO;
        import it.biblioteca.progettoBiblioteca.entities.EditoreEntity;
        import it.biblioteca.progettoBiblioteca.mapper.EditoreMapper;
        import it.biblioteca.progettoBiblioteca.repository.EditoreRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
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


    public List<EditoreDTO> getEditoreDTO() {
        List<EditoreEntity> listaEditori = editoreRepository.findAll();
        List<EditoreDTO> listaDTO = new ArrayList<>();
        for (EditoreEntity l : listaEditori) {
            listaDTO.add(EditoreMapper.EDITORE_MAPPER.entityToDTO(l));
        }
        return listaDTO;
    }

    public EditoreDTO getEditoreDTOById(Long id){
        Optional<EditoreEntity> editoreEntity = getEditoreById(id);
        return editoreEntity.map(EditoreMapper.EDITORE_MAPPER::entityToDTO).orElse(null);
    }

    public EditoreDTO saveEditoreDTO(EditoreDTO editoreDTO){
        return EditoreMapper.EDITORE_MAPPER.entityToDTO(editoreRepository.save(EditoreMapper.EDITORE_MAPPER.dtoToEditore(editoreDTO)));
    }

    public EditoreDTO updateEditoreDTO(EditoreDTO editoreDTONew){
        Optional<EditoreEntity> editoreEntity = getEditoreById(editoreDTONew.getId());
        if(editoreEntity.isEmpty()) throw new NullPointerException();
        return editoreDTONew;
    }
}

