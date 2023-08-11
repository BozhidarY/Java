package lab6.Exceptions;

public class WrongPhoneNumberException extends Exception {
    public String getMessage() {
        return "Wrong phone number";
    }
}
