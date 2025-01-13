package sg.edu.nus.iss.paf_day24l.models.exceptions;

public class UnableToCreateBookException extends RuntimeException {
    
    public UnableToCreateBookException(){

    }

    public UnableToCreateBookException(String message){
        super(message);
    }

    public UnableToCreateBookException(String message, Throwable throwable){
        super(message, throwable);
    }

}
