package lab6.Constructor;

import lab6.Exceptions.NoMoreProductsException;

public abstract class Product {
    private int inventoryNumber;
    private double price;
    private int quantity;
    private String provider;

    public Product(int inventoryNumber, double price, int quantity, String provider) {
        this.inventoryNumber = inventoryNumber;
        this.price = price;
        this.quantity = quantity;
        this.provider = provider;
    }

    abstract double getPromotionalPrice();

    abstract boolean sellProductPrice(int soldItems) throws NoMoreProductsException;

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
