package sg.edu.nus.iss.paf_day24l.models.exceptions;

public class AccountInactiveException extends RuntimeException {
    
    public AccountInactiveException(){

    }

    public AccountInactiveException(String message){
        super(message);
    }

    public AccountInactiveException(String message, Throwable throwable){
        super(message, throwable);
    }
    
}
