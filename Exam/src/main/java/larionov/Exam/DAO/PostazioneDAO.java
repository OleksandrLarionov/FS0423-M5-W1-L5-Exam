package larionov.Exam.DAO;

import larionov.Exam.ENUM.STATO;
import larionov.Exam.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneDAO extends JpaRepository<Postazione,Long> {
    List<Postazione> findByStatoDellaPostazione(STATO stato);
}
