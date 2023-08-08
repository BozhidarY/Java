package lab4;

public class Books extends Stocks {
    private String authorName;
    private String title;

    public Books(int stockN, int price, String authorName, String title) throws
            PowerException,PriceException{
        super(stockN, price);
        this.authorName = authorName;
        this.title = title;
    }

    @Override
    public double checkPromo() {
        return getPrice() - getPrice()*15/100;
    }

    @Override
    public void checkPrice() throws PriceException {
        if(getPrice() < 15){
            throw new PriceException();
        }
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
