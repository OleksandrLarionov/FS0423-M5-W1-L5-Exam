package larionov.Exam.entities;

import jakarta.persistence.*;
import larionov.Exam.ENUM.STATO;
import larionov.Exam.ENUM.TIPOPOSTAZIONE;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public Postazione(String descrizione, TIPOPOSTAZIONE tipoDellaPostazione, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipoDellaPostazione = tipoDellaPostazione;
        Random rndm = new Random();
        if(tipoDellaPostazione == TIPOPOSTAZIONE.PRIVATO) numeroMassimoDiOccupanti = 1;
        else this.numeroMassimoDiOccupanti = rndm.nextInt(1,10);
        this.edificio = edificio;
        this.statoDellaPostazione = STATO.LIBERA;
        this.prenotazioni = new ArrayList<>();
        this.edifici = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "descrizione='" + descrizione + '\'' +
                ", tipoDellaPostazione=" + tipoDellaPostazione +
                ", numeroMassimoDiOccupanti=" + numeroMassimoDiOccupanti +
                ", edificio=" + edificio +
                ", statoDellaPostazione=" + statoDellaPostazione +
                '}';
    }
}
