package larionov.Exam.DAO;

import larionov.Exam.entities.Utente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtenteService {
    @Autowired
    private UtenteDAO utenteDAO;

    public void salvaUtenteNelDb(Utente utente){
        utenteDAO.save(utente);
        log.info("L'utente" + " " + utente.getNome() + " " + utente.getCognome());
    }
}
