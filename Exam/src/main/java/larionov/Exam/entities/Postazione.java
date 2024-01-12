package larionov.Exam.entities;

import jakarta.persistence.*;
import larionov.Exam.ENUM.STATO;
import larionov.Exam.ENUM.TIPOPOSTAZIONE;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "postazione")
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TIPOPOSTAZIONE tipoDellaPostazione;
    private Integer numeroMassimoDiOccupanti;
    @ManyToOne
    @JoinColumn(name = "id_edificio")  // Modifica il nome della colonna di collegamento se necessario
    private Edificio edificio;
    @Enumerated(EnumType.STRING)
    private STATO statoDellaPostazione;

    @OneToMany(mappedBy = "postazione", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    @ManyToMany(mappedBy = "postazioni")
    private List<Edificio> edifici;
}
