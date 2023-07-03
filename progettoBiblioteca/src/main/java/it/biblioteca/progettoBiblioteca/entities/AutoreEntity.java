package it.biblioteca.progettoBiblioteca.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "autore")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AutoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;
}
