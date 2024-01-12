package larionov.Exam.entities;

import com.github.javafaker.Faker;
import larionov.Exam.GestionePrenotazioniApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    Faker faker = new Faker();
    public static AnnotationConfigApplicationContext ctx;
    @Override
    public void run(String... args) throws Exception {
        ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);
    }
}
