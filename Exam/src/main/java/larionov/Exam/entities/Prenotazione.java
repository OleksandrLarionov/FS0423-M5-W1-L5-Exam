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

}
