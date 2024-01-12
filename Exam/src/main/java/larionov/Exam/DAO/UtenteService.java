package larionov.Exam.DAO;

import larionov.Exam.entities.Postazione;
import larionov.Exam.entities.Prenotazione;
import larionov.Exam.entities.Utente;
import larionov.Exam.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtenteService {
    @Autowired
    private UtenteDAO utenteDAO;

    public void salvaUtenteNelDb(Utente utente){
        utenteDAO.save(utente);
        log.info("L'utente" + " " + utente.getNome() + " " + utente.getCognome());
    }

    public Utente findById(long id) throws ItemNotFoundException {
        return utenteDAO.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }


}
