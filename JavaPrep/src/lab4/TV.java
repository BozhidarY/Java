package lab4;

public class TV extends Stocks implements ElectricalAppliance{
    private String manufacturer;
    private String model;
    private double power;

    public TV(int stockN, int price, String manufacturer, String model, double power) throws PowerException,PriceException {
        super(stockN, price);
        this.manufacturer = manufacturer;
        this.model = model;
        this.power = power;
    }

    @Override
    public double checkPromo() {
        return getPrice() - getPrice()*9/100;
    }

    @Override
    public void ElectricalAppliance() {
        power = power - 15;
    }

    @Override
    public void checkPrice() throws PriceException{
        if(getPrice() < 10){
            throw new PriceException();
        }
    }

    public void validatePower() throws PowerException {
        if (power < 200) {
            throw new PowerException();
        }
    }

    public void setPower(double power){
            this.power = power;
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

    public double getPower() {
        return power;
    }





}
