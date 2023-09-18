package Files.lab6.validation;

public class WrongPhoneNumberException extends Exception {
    @Override
    public String getMessage() {
        return "invalid phone number";
    }
}
