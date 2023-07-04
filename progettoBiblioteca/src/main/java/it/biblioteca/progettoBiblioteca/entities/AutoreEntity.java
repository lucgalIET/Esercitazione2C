package it.biblioteca.progettoBiblioteca.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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


    @ManyToMany
    @JoinTable(
            name = "autore_libro",
            joinColumns = @JoinColumn(name = "autore_fk"),
            inverseJoinColumns = @JoinColumn(name = "libro_fk"))
    @JsonManagedReference
    private List<LibroEntity>  listaLibri;

}
