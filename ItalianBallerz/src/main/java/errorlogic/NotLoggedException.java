package errorlogic;

public class NotLoggedException extends Exception{

    public NotLoggedException (String message){
        super("this was the original message :" + message);
    }

    public NotLoggedException (Throwable cause) {
        super(cause);
    }

    public NotLoggedException (String message, Throwable cause) {
        super(" +++ " + message + " +++ " + "\n" + "L'utente non è loggato", cause);
    }
}
