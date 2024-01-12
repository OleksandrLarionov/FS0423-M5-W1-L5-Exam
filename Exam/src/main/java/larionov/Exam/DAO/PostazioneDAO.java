package larionov.Exam.DAO;

import larionov.Exam.ENUM.CITTA;
import larionov.Exam.ENUM.STATO;
import larionov.Exam.ENUM.TIPOPOSTAZIONE;
import larionov.Exam.entities.Postazione;
import larionov.Exam.entities.Prenotazione;
import larionov.Exam.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione, Long> {
    List<Postazione> findByStatoDellaPostazione(STATO stato);
    //    List<Postazione> findByPostazioneEGiorno (Postazione postazione, LocalDate giorno);
}
