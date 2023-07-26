package it.biblioteca.progettoBiblioteca.mapper;

import it.biblioteca.progettoBiblioteca.dto.EditoreDTO;
import it.biblioteca.progettoBiblioteca.entities.EditoreEntity;
import lombok.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EditoreMapper {

    EditoreMapper EDITORE_MAPPER = Mappers.getMapper(EditoreMapper.class);

    @Mapping(source = "id", target="id")
    @Mapping(source = "nome", target ="nome")
    EditoreDTO entityToDTO(EditoreEntity editoreEntity);

    @Mapping(source ="id", target="id")
    @Mapping(source = "nome", target="nome")
    EditoreEntity dtoToEditore(EditoreDTO editoreDTO);


}
