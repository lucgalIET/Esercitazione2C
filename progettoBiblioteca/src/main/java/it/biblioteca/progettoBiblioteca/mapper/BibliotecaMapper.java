package it.biblioteca.progettoBiblioteca.mapper;

import it.biblioteca.progettoBiblioteca.dto.BibliotecaDTO;
import it.biblioteca.progettoBiblioteca.entities.BibliotecaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BibliotecaMapper {

    BibliotecaMapper BIBLIOTECA_MAPPER = Mappers.getMapper(BibliotecaMapper.class);

    @Mapping(source = "idBiblioteca", target ="id")
    @Mapping(source = "nome", target = "nome")
    BibliotecaDTO entityToDto(BibliotecaEntity bibliotecaEntity);

    @Mapping(source = "id", target ="idBiblioteca")
    @Mapping(source = "nome", target = "nome")
    BibliotecaEntity dtoToEntity(BibliotecaDTO bibliotecaDTO);
}
