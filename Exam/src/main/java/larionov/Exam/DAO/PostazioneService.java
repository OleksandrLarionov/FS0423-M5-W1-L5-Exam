package larionov.Exam.DAO;

import larionov.Exam.entities.Postazione;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostazioneService {
    @Autowired
    private PostazioneDAO postazioneDAO;

    public void salvaLaPostazioneNelDb(Postazione postazione){
        postazioneDAO.save(postazione);
        log.info("La postazione è stata salvata con successo " + postazione);
    }
}
