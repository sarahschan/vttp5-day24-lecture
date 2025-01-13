package sg.edu.nus.iss.paf_day24l.models.exceptions;

public class AccountNotFoundException extends RuntimeException {
    
    public AccountNotFoundException(){

    }

    public AccountNotFoundException(String message){
        super(message);
    }

    public AccountNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
    
}
