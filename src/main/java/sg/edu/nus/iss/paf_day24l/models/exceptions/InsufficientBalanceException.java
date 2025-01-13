package sg.edu.nus.iss.paf_day24l.models.exceptions;

public class InsufficientBalanceException extends RuntimeException {
    
    public InsufficientBalanceException(){

    }

    public InsufficientBalanceException(String message){
        super(message);
    }

    public InsufficientBalanceException(String message, Throwable throwable){
        super(message, throwable);
    }
    
}
