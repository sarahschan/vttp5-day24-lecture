package sg.edu.nus.iss.paf_day24l.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.paf_day24l.models.exceptions.AccountInactiveException;
import sg.edu.nus.iss.paf_day24l.models.exceptions.AccountNotFoundException;
import sg.edu.nus.iss.paf_day24l.models.exceptions.ErrorMessage;
import sg.edu.nus.iss.paf_day24l.models.exceptions.InsufficientBalanceException;
import sg.edu.nus.iss.paf_day24l.models.exceptions.UnableToCreateAccountException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        ex.printStackTrace();
        
        ErrorMessage message = new ErrorMessage();
            message.setStatus(response.getStatus());
            message.setMessage(ex.getMessage());
            message.setTimeStamp(new Date());
            message.setEndPoint(request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }


    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleAccountNotFoundException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        ErrorMessage message = new ErrorMessage();
            message.setStatus(404);
            message.setMessage(ex.getMessage());
            message.setTimeStamp(new Date());
            message.setEndPoint(request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }


    @ExceptionHandler(AccountInactiveException.class)
    public ResponseEntity<ErrorMessage> handleAccountInactiveException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        ErrorMessage message = new ErrorMessage();
            message.setStatus(response.getStatus());
            message.setMessage(ex.getMessage());
            message.setTimeStamp(new Date());
            message.setEndPoint(request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }


    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ErrorMessage> handleInsufficientBalanceException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        ErrorMessage message = new ErrorMessage();
            message.setStatus(response.getStatus());
            message.setMessage(ex.getMessage());
            message.setTimeStamp(new Date());
            message.setEndPoint(request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }


    @ExceptionHandler(UnableToCreateAccountException.class)
    public ResponseEntity<ErrorMessage> handleUnableToCreateAccountException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        ErrorMessage message = new ErrorMessage();
            message.setStatus(500);
            message.setMessage(ex.getMessage());
            message.setTimeStamp(new Date());
            message.setEndPoint(request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        
    }


}
