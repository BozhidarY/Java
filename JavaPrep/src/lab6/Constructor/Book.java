package lab6.Constructor;

import lab6.Exceptions.NoMoreProductsException;

import java.io.IOException;

public class Book extends Product {
    private String author;
    public Book(int inventoryNumber, double price, int quantity, String provider, String author, String title) throws NoMoreProductsException {
        super(inventoryNumber, price, quantity, provider);
        this.author = author;
        this.title = title;
    }

    private String title;

    @Override
    public double getPromotionalPrice() {
        return getPrice() - getPrice()*50/100;
    }

    @Override
    public boolean sellProductPrice(int soldItems) throws NoMoreProductsException {
        if(getQuantity() > soldItems){
            setQuantity(getQuantity() - soldItems);
            return true;
        }else{
            throw new NoMoreProductsException();
        }
    }


}
