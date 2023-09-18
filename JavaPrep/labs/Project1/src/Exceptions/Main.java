package Exceptions;

public class Main {
    public static void main(String[] args) {
        TV tv = null;
        Books book = null;
        try {
            tv = new TV(4325, "LG", "L1", 50, 1989.99);
        } catch (PriceException | PowerException e) {
            System.out.println(e.getMessage());
        }
        try {
            book = new Books(64327, "Some title", "Some Author", -19.99);
        } catch (PriceException e) {
            System.out.println(e.getMessage());
        }
        if (tv != null){System.out.println("Promo tv: " + tv.checkPromo());}
        if (book != null){System.out.println("Promo book: " + book.checkPromo());



    }
}