package it.biblioteca.progettoBiblioteca.mapper;

import it.biblioteca.progettoBiblioteca.dto.AutoreDTO;
import it.biblioteca.progettoBiblioteca.dto.LibroDTO;
import it.biblioteca.progettoBiblioteca.entities.AutoreEntity;
import it.biblioteca.progettoBiblioteca.entities.LibroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface LibroMapper {

    LibroMapper LIBRO_MAPPER = Mappers.getMapper(LibroMapper.class);
    @Mapping(source = "id", target ="id")
    @Mapping(source = "titolo", target ="titolo")
    @Mapping(source = "isbn", target ="isbn")
    LibroDTO entityToDTO(LibroEntity libroEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "titolo", target = "titolo")
    @Mapping(source = "isbn", target = "isbn")
    LibroEntity dtoToEntity(LibroDTO libroDTO);
}
