package Files.lab6.entities;

import Files.lab6.validation.NoMoreProductsException;

public class Book extends Product {
    private String author;
    private String title;

    public Book(String inventorID, double price, int quantity, Provider provider, String author, String title) {
        super(inventorID, price, quantity, provider);
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public double getPromotionalPrice() {
        return this.getPrice()*0.5;
    }

    @Override
    public boolean sellProduct(int quantity) throws NoMoreProductsException {
        if(this.getQuantity() >= quantity){
            this.setQuantity(this.getQuantity() - quantity);
            return true;
        }else {
            throw new NoMoreProductsException();
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                "} " + super.toString();
    }
}
