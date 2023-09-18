package Files.lab7;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class BrokenDevice extends Device implements Serializable {
    private String reason;
    private int daysToRepair;


    public BrokenDevice(String brand, String model, double price, String reasons, int daysToRepair) {
        super(brand, model, price);
        this.reason = reasons;
        this.daysToRepair = daysToRepair;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getDaysToRepair() {
        return daysToRepair;
    }

    public void setDaysToRepair(int daysToRepair) {
        this.daysToRepair = daysToRepair;
    }

    @Override
    public String toString() {
        return "BrokenDevice{" +
                "brand='" + super.getBrand() + '\'' +
                ", model='" + super.getModel() + '\'' +
                ", price=" + super.getPrice() +
                ", reason='" + reason + '\'' +
                ", daysToRepair=" + daysToRepair +
                "} ";
    }

    public static BrokenDevice NewBrokenDevice(){
        Scanner scanner = new Scanner(System.in);
        return new BrokenDevice(scanner.nextLine(), scanner.nextLine(),
                scanner.nextDouble(), scanner.nextLine(), scanner.nextInt());
    }
}
