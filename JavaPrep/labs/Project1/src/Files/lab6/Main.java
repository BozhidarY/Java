package Files.lab6;

import Files.lab6.black_friday_event.BlackFriday;
import Files.lab6.validation.NoMoreProductsException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BlackFriday.processSales();
        System.out.println(Arrays.toString(BlackFriday.books));
        System.out.println(Arrays.toString(BlackFriday.electronics));
        System.out.println("Book 0 price: " + BlackFriday.books[0].getPromotionalPrice());
        try {
            System.out.println("Book 0 buy: " + BlackFriday.books[0].sellProduct(100));
            System.out.println("Book 0 buy: " + BlackFriday.books[0].sellProduct(100));
            System.out.println("Book 0: " + BlackFriday.books[0]);
            System.out.println("Book 0 buy: " + BlackFriday.books[0].sellProduct(1000));
        } catch (NoMoreProductsException e) {
            System.err.println(e.getMessage());
        }
    }
}
