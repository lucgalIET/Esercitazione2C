package it.biblioteca.progettoBiblioteca.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "biblioteca_fk")
    @JsonBackReference(value="user-movement")
    private BibliotecaEntity bibliotecaEntity;

    @ManyToOne
    @JoinColumn(name = "autore_fk")
    @JsonBackReference
    private AutoreEntity autoreEntity;

}

