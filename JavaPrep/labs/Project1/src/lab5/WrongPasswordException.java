package lab5;

public class WrongPasswordException extends Exception {

    @Override
    public String getMessage() {
        return "Invalid password";
    }
}
