package larionov.Exam.DAO;

import larionov.Exam.entities.Prenotazione;
import larionov.Exam.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteDAO extends JpaRepository<Utente,Long> {

}
