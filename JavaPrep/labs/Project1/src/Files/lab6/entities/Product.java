package Files.lab6.entities;

import Files.lab6.validation.NoMoreProductsException;

public abstract class Product {
    private String inventorID;
    private double price;
    private int quantity;
    private Provider provider;

    public Product(String inventorID, double price, int quantity, Provider provider) {
        this.inventorID = inventorID;
        this.price = price;
        this.quantity = quantity;
        this.provider = provider;
    }

    public String getInventorID() {
        return inventorID;
    }

    public void setInventorID(String inventorID) {
        this.inventorID = inventorID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public abstract double getPromotionalPrice();
    public abstract boolean sellProduct(int quantity) throws NoMoreProductsException;

    @Override
    public String toString() {
        return "Product{" +
                "inventorID='" + inventorID + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", provider=" + provider +
                '}';
    }
}
