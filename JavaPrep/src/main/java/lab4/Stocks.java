package lab4;

public abstract class Stocks {
    private int stockN;
    private double price;

    public Stocks(int stockN, float price){
        this.stockN = stockN;
        this.price = price;
    }

    public abstract double checkPromo();
    public abstract void checkPrice() throws PriceException;

    public int getStockN() {
        return stockN;
    }

    public void setStockN(int stockN) {
        this.stockN = stockN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
