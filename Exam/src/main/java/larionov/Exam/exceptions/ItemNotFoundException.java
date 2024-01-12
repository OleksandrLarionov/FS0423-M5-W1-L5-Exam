package larionov.Exam.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(long id) {
        super("Il record con id " + id + " non è stato trovato!");
    }

}
