package larionov.Exam.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "prenotazione")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_postazione")
    private Postazione postazione;
    private LocalDate dataDellaPrenotazione;
    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    public Prenotazione(Postazione postazione, Utente utente) {
        this.postazione = postazione;
        this.dataDellaPrenotazione = LocalDate.now();
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", postazione=" + postazione +
                ", dataDellaPrenotazione=" + dataDellaPrenotazione +
                ", utente=" + utente +
                '}';
    }
}
