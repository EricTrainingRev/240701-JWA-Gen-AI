package exception;

/*
    If we extend "Exception" then this custom exception class becomes a "checked" exception
    If we extend "RuntimeException" then this custom exception class becomes an "unchecked" exception
 */
public class IncompatibleCaseException extends RuntimeException{
    public IncompatibleCaseException(String message){
        super(message);
    }
}
