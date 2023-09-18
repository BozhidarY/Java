package lab12.Validators;

public class WrongCredentialsException extends Exception{
    public String getMessage(){
        return "Wrong credentials";
    }
}
