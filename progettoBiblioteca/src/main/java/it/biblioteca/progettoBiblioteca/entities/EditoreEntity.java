package it.biblioteca.progettoBiblioteca.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "editore")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EditoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "partita_iva")
    private Long partitaIva;

    @Column(name = "contatto")
    private String contatto;

//    @OneToOne(mappedBy = "editore")
//    private AutoreEntity autore;
}
