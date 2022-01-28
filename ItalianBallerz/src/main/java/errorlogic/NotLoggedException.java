package errorlogic;

public class NotLoggedException extends Exception{
    private static final long serialVersionUID = 1L;

    public NotLoggedException (String message){
        super("this was the original message :" + message);
    }

    public NotLoggedException (Throwable cause) {
        super(cause);
    }

    public NotLoggedException (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
