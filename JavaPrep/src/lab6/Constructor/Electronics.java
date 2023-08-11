package lab6.Constructor;

import lab6.Exceptions.NoMoreProductsException;

public class Electronics extends Product {
    private String manufacturer;
    private String model;

    public Electronics(int inventoryNumber, double price, int quantity, String provider, String manufacturer, String model) throws NoMoreProductsException {
        super(inventoryNumber, price, quantity, provider);
        this.manufacturer = manufacturer;
        this.model = model;
    }

    @Override
    double getPromotionalPrice() {
        return getPrice() - getPrice()*10/100;
    }

    @Override
    boolean sellProductPrice(int soldItems) throws NoMoreProductsException {
        if(getQuantity() > soldItems){
            return true;
        }else{
            throw new NoMoreProductsException();
        }
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
    public String toString() {
        return "Electronics{" +
                "Provider" + Provider.getName() + Provider.getPhoneNumber() +
                "inventoryNumber='" + getInventoryNumber() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", provider=" + getProvider() + // Print provider's name
                ", manufacturer='" + getManufacturer() + '\'' +
                ", model='" + getModel() + '\'' +
                '}';
    }


}
