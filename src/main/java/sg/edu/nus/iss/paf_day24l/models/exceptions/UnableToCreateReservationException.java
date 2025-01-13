package sg.edu.nus.iss.paf_day24l.models.exceptions;

public class UnableToCreateReservationException extends RuntimeException {
    
    public UnableToCreateReservationException(){

    }

    public UnableToCreateReservationException(String message){
        super(message);
    }

    public UnableToCreateReservationException(String message, Throwable throwable){
        super(message, throwable);
    }

}
