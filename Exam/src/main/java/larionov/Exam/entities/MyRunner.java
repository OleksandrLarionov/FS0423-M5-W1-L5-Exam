package larionov.Exam.entities;

import com.github.javafaker.Faker;
import larionov.Exam.DAO.EdificioService;
import larionov.Exam.DAO.PostazioneService;
import larionov.Exam.DAO.PrenotazioneService;
import larionov.Exam.DAO.UtenteService;
import larionov.Exam.ENUM.CITTA;
import larionov.Exam.ENUM.TIPOPOSTAZIONE;
import larionov.Exam.GestionePrenotazioniApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MyRunner implements CommandLineRunner {
    Faker faker = new Faker();
    Random rndm = new Random();
    @Autowired
    UtenteService utenteService;
    @Autowired
    EdificioService edificioService;
    @Autowired
    PostazioneService postazioneService;
    @Autowired
    PrenotazioneService prenotazioneService;
    public static AnnotationConfigApplicationContext ctx;
    @Override
    public void run(String... args) throws Exception {
        ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);
//        ******************Creazione Utenti*************************
        Utente aldo = new Utente("giovanni"+rndm.nextInt(1,100),"Aldo","Baglio","aldo.baglio@mail.com");
        Utente giovanni = new Utente("giovanni"+rndm.nextInt(1,100),"Giovanni","Storti","giovanni.storti@mail.com");
        Utente giacomo = new Utente("giacomo"+rndm.nextInt(1,100),"Giacomo","Poretti","giacomo.poretti@mail.com");

        utenteService.salvaUtenteNelDb(aldo);
        utenteService.salvaUtenteNelDb(giovanni);
        utenteService.salvaUtenteNelDb(giacomo);

//        ******************Creazione Edifici*************************
        Edificio roma = new Edificio("Nuvola","Viale Asia 6", CITTA.ROMA);
        Edificio milano = new Edificio("Centro Congressi","Corso Venezia 51",CITTA.MILANO);
        Edificio venezia = new Edificio("Centro Congressi Venezia","Via Forte Margherita 191",CITTA.VENEZIA);

        edificioService.salvaEdificioNelDb(roma);
        edificioService.salvaEdificioNelDb(milano);
        edificioService.salvaEdificioNelDb(venezia);

//        ******************Creazione Postazioni*************************
        Postazione postazione = new Postazione("All'aperto", TIPOPOSTAZIONE.OPENSPACE, venezia);
        Postazione postazione2 = new Postazione("All'chiuso", TIPOPOSTAZIONE.SALA_RIUNIONI, venezia);
        Postazione postazione3 = new Postazione("All'chiuso", TIPOPOSTAZIONE.PRIVATO, roma);
        Postazione postazione4 = new Postazione("All'chiuso", TIPOPOSTAZIONE.PRIVATO, roma);
        Postazione postazione5 = new Postazione("All'chiuso", TIPOPOSTAZIONE.SALA_RIUNIONI, milano);

        postazioneService.salvaLaPostazioneNelDb(postazione);
        postazioneService.salvaLaPostazioneNelDb(postazione2);
        postazioneService.salvaLaPostazioneNelDb(postazione3);
        postazioneService.salvaLaPostazioneNelDb(postazione4);
        postazioneService.salvaLaPostazioneNelDb(postazione5);

//        ******************Creazione Prenotazioni*************************

        Prenotazione aldoPrenota = new Prenotazione(postazione3,aldo);
        prenotazioneService.salvaLaPrenotazioneNelDb(aldoPrenota);

    }
}
