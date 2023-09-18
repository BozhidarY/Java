package lab8.Exceptions;

public class NoMoreTicketException extends Exception {
    public String getMessage(){
        return "No more tickets";
    }
}
