package larionov.Exam.entities;

import jakarta.persistence.*;
import larionov.Exam.ENUM.CITTA;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
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

    public Edificio(String nomeDelEdificio, String indirizzo, CITTA citta) {
        this.nomeDelEdificio = nomeDelEdificio;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.postazioni = new ArrayList<>();
    }

    public void aggiungiLaPostazioneAllEdificio(Postazione postazione){
        postazioni.add(postazione);
    }

    public void listaPostazioniNellEdificio(){
        postazioni.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", nomeDelEdificio='" + nomeDelEdificio + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta=" + citta +
                '}';
    }
}
