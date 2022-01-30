package errorlogic;

public class AlreadyReserved extends Exception {

    public AlreadyReserved(String message){
        super("this was the original message :" + message);
    }

    public AlreadyReserved (Throwable cause) {
        super(cause);
    }

    public AlreadyReserved (String message, Throwable cause) {
        super(" --- " + message + " --- " + "\n" +
                "L'utente era già prenotato per questo slot orario", cause);
    }
}
