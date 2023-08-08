package lab4;

public class Main {
    public static void main(String[] args) {
        try {
            Books book = new Books(50, 10, "John Doe", "Java Programming");
            book.checkPrice();
            double bookPromoPrice = book.checkPromo();
            System.out.println("Book Promo Price: " + bookPromoPrice);

            TV tv = new TV(100, 456, "Sony", "Bravia", 150);
            double tvPromoPrice = tv.checkPromo();
            System.out.println("TV Promo Price: " + tvPromoPrice);

            tv.ElectricalAppliance();

            tv.validatePower();

            System.out.println("TV Power Consumption: " + (int) tv.getPower());
        } catch (PriceException | PowerException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
