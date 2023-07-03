package it.biblioteca.progettoBiblioteca.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "biblioteca")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BibliotecaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idBiblioteca;

    @Column(name = "nome")
    private String nome;

    @Column(name = "indirizzo")
    private String indirizzo;

//    @OneToMany
//    @JsonManagedReference
//    private List<LibroEntity> listaLibroEntity;
}
