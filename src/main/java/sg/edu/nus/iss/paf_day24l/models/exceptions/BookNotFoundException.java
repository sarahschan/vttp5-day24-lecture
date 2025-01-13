package sg.edu.nus.iss.paf_day24l.models.exceptions;

public class BookNotFoundException extends RuntimeException {
    
    public BookNotFoundException(){

    }

    public BookNotFoundException(String message){
        super(message);
    }

    public BookNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
    
}
