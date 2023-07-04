package it.biblioteca.progettoBiblioteca.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AutoreDTO {

    private Long id;
    private String nome;
    private String cognome;
}
