package errorlogic;

public class MyException extends Exception{
    public MyException(){super();}

    public MyException (String message){
        super("this was the original message :" + message);
    }

    public MyException (Throwable cause) {
        super(cause);
    }

    public MyException (String message, Throwable cause) {
        super(" +++ " + message + " +++ ", cause);
    }
}
