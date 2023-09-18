package Files.lab7;

import java.io.Serializable;
import java.util.Scanner;

public class Device implements Serializable {
    private String brand;
    private String model;
    private double price;

    public Device(String brand, String model, double price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Device{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    public static Device NewDevice(){
        Scanner scanner = new Scanner(System.in);
        return new Device(scanner.nextLine(), scanner.nextLine(), scanner.nextDouble());
    }
}


