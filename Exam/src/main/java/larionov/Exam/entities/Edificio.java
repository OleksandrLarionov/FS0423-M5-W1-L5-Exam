package larionov.Exam.entities;

import jakarta.persistence.*;
import larionov.Exam.ENUM.CITTA;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "edificio")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDelEdificio;
    private String indirizzo;
    @Enumerated(EnumType.STRING)
    private CITTA citta;

    @ManyToMany
    @JoinTable(
            name = "edificio_postazione",
            joinColumns = @JoinColumn(name = "id_edificio"),
            inverseJoinColumns = @JoinColumn(name = "id_postazione")
    )
    private List<Postazione> postazioni;
}
