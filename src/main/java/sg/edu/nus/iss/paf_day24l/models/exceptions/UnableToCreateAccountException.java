package sg.edu.nus.iss.paf_day24l.models.exceptions;

public class UnableToCreateAccountException extends RuntimeException {
    
    public UnableToCreateAccountException(){

    }

    public UnableToCreateAccountException(String message){
        super(message);
    }

    public UnableToCreateAccountException(String message, Throwable throwable){
        super(message, throwable);
    }

}
