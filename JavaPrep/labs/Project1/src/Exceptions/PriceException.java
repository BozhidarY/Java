package Exceptions;

public class PriceException extends Exception{

    @Override
    public String getMessage() {
        return "Price is not correct";
    }
}