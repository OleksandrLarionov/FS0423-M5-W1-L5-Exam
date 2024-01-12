package larionov.Exam.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
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

    public Utente(String userName, String nome, String cognome, String email) {
        this.userName = userName;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.prenotazioni = new ArrayList<>();
    }

    public void aggiungiLaPrenotazione(Prenotazione prenotazione){
        prenotazioni.add(prenotazione);
    }

    @Override
    public String toString() {
        return "Utente{" +
                "idUtente=" + idUtente +
                ", userName='" + userName + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
