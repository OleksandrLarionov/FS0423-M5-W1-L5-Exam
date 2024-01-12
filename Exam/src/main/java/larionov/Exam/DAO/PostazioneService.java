package larionov.Exam.DAO;

import larionov.Exam.ENUM.CITTA;
import larionov.Exam.ENUM.STATO;
import larionov.Exam.ENUM.TIPOPOSTAZIONE;
import larionov.Exam.entities.Postazione;
import larionov.Exam.entities.Prenotazione;
import larionov.Exam.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class PostazioneService {
    @Autowired
    private PostazioneDAO postazioneDAO;

    public void salvaLaPostazioneNelDb(Postazione postazione) {
        postazioneDAO.save(postazione);
        log.info("La postazione è stata salvata con successo " + postazione);
    }

    public Postazione findById(long id) throws ItemNotFoundException {
        return postazioneDAO.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public void findByIdAndUpdate(long id, Postazione postazione) {
        Postazione found = this.findById(id);
        found.setStatoDellaPostazione(postazione.getStatoDellaPostazione());
        postazioneDAO.save(found);
        log.info("Prenotazione con id: " + id + " aggiornata con successo!");
    }

    public List<Postazione> filterByStatoDellaPostazione(STATO stato) {
        return postazioneDAO.findByStatoDellaPostazione(stato);
    }

    /*    public List<Postazione> liberaPerGiornoX(Postazione postazione, LocalDate giorno) {
            return postazioneDAO.findByPostazioneEGiorno(postazione, giorno);
        }*/
/*    public List<Postazione> filterByTipoECitta(TIPOPOSTAZIONE tipo, CITTA citta) {
        return postazioneDAO.findByTipoECitta(tipo, citta);
    }*/
}
