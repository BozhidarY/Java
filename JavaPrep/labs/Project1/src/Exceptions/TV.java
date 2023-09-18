package Exceptions;

public class TV extends Stocks implements ElectricalAppliance{

    private String brand;
    private String model;
    private int power;

    public TV(int id, String brand, String model, int power, double price) throws PriceException, PowerException {
        super(price, id);
        this.brand = brand;
        this.model = model;
        this.setPower(power);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) throws PowerException{
        if(power <= 200){
            throw new PowerException();
        }else{
            this.power = power;
        }
    }

    @Override
    public double checkPromo() {
        return this.getPrice() - this.getPrice()*9/100;
    }

    @Override
    public double electricalAppliance() {
        return (double) this.power / 60;
    }
}