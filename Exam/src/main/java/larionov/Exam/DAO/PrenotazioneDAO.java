package larionov.Exam.DAO;

import larionov.Exam.entities.Prenotazione;
import larionov.Exam.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione,Long> {
    List<Prenotazione> findByUtente(Utente utente);
}
