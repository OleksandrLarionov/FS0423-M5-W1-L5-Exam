package larionov.Exam.DAO;

import larionov.Exam.ENUM.STATO;
import larionov.Exam.entities.Postazione;
import larionov.Exam.entities.Prenotazione;
import larionov.Exam.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;
    @Autowired
    PostazioneService postazioneService;

    public void salvaLaPrenotazioneNelDb(Prenotazione prenotazione) {
        Long idPostazione = prenotazione.getPostazione().getId();
        if (prenotazione.getPostazione().getStatoDellaPostazione() != STATO.OCCUPATA) {
            prenotazioneDAO.save(prenotazione);
            prenotazione.getPostazione().setStatoDellaPostazione(STATO.OCCUPATA);
            postazioneService.findByIdAndUpdate(idPostazione, prenotazione.getPostazione());

            log.info("La prenotazione è stata confermata a nome " +
                    " " + prenotazione.getUtente().getNome() +
                    " " + prenotazione.getUtente().getCognome() +
                    " " + "per il giono " + prenotazione.getDataDellaPrenotazione() +
                    " " + prenotazione.getPostazione());
        } else log.info("****La Postazione è Occupata*******" + "Puoi comunque riprovare domani " + prenotazione.getUtente().getNome());
    }

    public Prenotazione findById(long id) throws ItemNotFoundException {
        return prenotazioneDAO.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public void findByIdAndUpdate(long id, Prenotazione prenotazione) {
        Prenotazione found = this.findById(id);
        found.setPostazione(prenotazione.getPostazione());
        found.setUtente(prenotazione.getUtente());
        prenotazioneDAO.save(found);
        log.info("Prenotazione con id: " + id + " aggiornata con successo!");
    }
}
