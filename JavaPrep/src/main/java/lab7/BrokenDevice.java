package lab7;

import java.io.Serializable;
import java.sql.Time;

public class BrokenDevice extends Device implements Serializable {

    private String damage;
    private String repairTime;

    public BrokenDevice(String brand, String model, double price, String damage, String repairTime) {
        super(brand, model, price);
        this.damage = damage;
        this.repairTime = repairTime;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(String repairTime) {
        this.repairTime = repairTime;
    }

    @Override
    public String toString() {
        return "BrokenDevice{" +
                super.toString() +
                " " +
                "damage='" + damage + '\'' +
                ", repairTime='" + repairTime + '\'' +
                '}';
    }
}
