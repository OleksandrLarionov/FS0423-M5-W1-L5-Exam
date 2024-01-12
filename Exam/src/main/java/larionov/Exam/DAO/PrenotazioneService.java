package larionov.Exam.DAO;

import larionov.Exam.entities.Prenotazione;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public void salvaLaPrenotazioneNelDb(Prenotazione prenotazione) {
        prenotazioneDAO.save(prenotazione);
        log.info("La prenotazione è stata confermata a nome " +
                " " + prenotazione.getUtente().getNome() +
                " " + prenotazione.getUtente().getCognome() +
                " " + "per il giono " + prenotazione.getDataDellaPrenotazione() +
                " " + prenotazione.getPostazione());
    }
}
