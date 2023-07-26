package it.biblioteca.progettoBiblioteca.mapper;

import it.biblioteca.progettoBiblioteca.dto.AutoreDTO;
import it.biblioteca.progettoBiblioteca.entities.AutoreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoreMapper {

    AutoreMapper AUTORE_MAPPER = Mappers.getMapper(AutoreMapper.class);
    @Mapping(source = "id", target ="id")
    @Mapping(source = "nome", target ="nome")
    @Mapping(source = "cognome", target ="cognome")
    AutoreDTO entityToDTO(AutoreEntity autoreEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "cognome", target = "cognome")
    AutoreEntity dtoToEntity(AutoreDTO autoreDTO);
}
