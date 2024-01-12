package larionov.Exam.entities;

import jakarta.persistence.*;


import java.util.List;
@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtente;
    private String userName;
    private String nome;
    private String cognome;
    private String email;
    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

}
