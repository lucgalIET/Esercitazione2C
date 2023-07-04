package it.biblioteca.progettoBiblioteca.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "libro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "genere")

    @ManyToOne
    @JoinColumn(name = "biblioteca_fk")
    private BibliotecaEntity bibliotecaEntity;


    @ManyToMany(mappedBy = "listaLibri")
    @JsonBackReference
    private List<AutoreEntity> listaAutore;

}

