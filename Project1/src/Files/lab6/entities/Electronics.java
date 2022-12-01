package Files.lab6.entities;

import Files.lab6.validation.NoMoreProductsException;

public class Electronics extends Product {

    private String manufacturer;
    private String model;

    public Electronics(String inventorID, double price, int quantity, Provider provider, String manufacturer, String model) {
        super(inventorID, price, quantity, provider);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public double getPromotionalPrice() {
        return this.getPrice() - this.getPrice()*10/100;
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
        return "Electronics{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                "} " + super.toString();
    }
}
