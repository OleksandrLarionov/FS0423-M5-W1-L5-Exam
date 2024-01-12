package larionov.Exam.DAO;

import larionov.Exam.entities.Edificio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EdificioService {
    @Autowired
    private EdificioDAO edificioDAO;

    public void salvaEdificioNelDb(Edificio edificio){
        edificioDAO.save(edificio);
        log.info("Edificio è stato salvato con successo " + edificio);
    }
}
