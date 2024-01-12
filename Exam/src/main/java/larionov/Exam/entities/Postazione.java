package larionov.Exam.entities;

import larionov.Exam.ENUM.STATO;
import larionov.Exam.ENUM.TIPOPOSTAZIONE;

import java.util.List;

public class Postazione {
    private Long id;
    private String descrizione;
    private TIPOPOSTAZIONE tipoDellaPostazione;
    private Integer numeroMassimoDiOccupanti;
    private Edificio edificio;
    private STATO statoDellaPostazione;
    private List<Prenotazione> prenotazioni;
}
