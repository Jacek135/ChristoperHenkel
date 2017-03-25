package tutorial.core.services.exceptions;

/**
 * Created by Jacek on 2017-03-25.
 */
public class AccountDoesNotExistException extends RuntimeException {
    public AccountDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public AccountDoesNotExistException(String message, Throwable cause){
        super(message, cause);
    }

    public AccountDoesNotExistException(String message){
        super(message);
    }

    public AccountDoesNotExistException(){}

}
