package exception;

/*
    If we extend "Exception" then this custom exception class becomes a "checked" exception
    If we extend "RuntimeException" then this custom exception class becomes an "unchecked" exception
 */

public class InvalidCaseException extends Exception{
    public InvalidCaseException(String message){
        super(message);
    }
}
