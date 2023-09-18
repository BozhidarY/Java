package lab4;

public class PriceException extends Exception {
    public String getMessage(){
        return "Price not enough";
    }
}
