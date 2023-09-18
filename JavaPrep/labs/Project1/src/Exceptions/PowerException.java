package Exceptions;

public class PowerException extends Exception{

    @Override
    public String getMessage() {
        return "Power value is not correct";
    }
}