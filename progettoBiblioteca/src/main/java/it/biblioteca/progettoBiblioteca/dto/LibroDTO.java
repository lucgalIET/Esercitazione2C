package it.biblioteca.progettoBiblioteca.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LibroDTO {

    private Long id;
    private String titolo;
    private String isbn;
}
