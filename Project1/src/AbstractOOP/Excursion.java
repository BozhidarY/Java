package AbstractOOP;

public class Excursion extends Trip implements numBights{
	private int numHotels;
	
	public Excursion(String destination, int numDays, double price, int numHotels) {
		super(destination,numDays,price);
		this.numHotels = numHotels;
	}

	public int getNumHotels() {
		return numHotels;
	}

	public void setNumHotels(int numHotels) {

		this.numHotels = numHotels;
	}

	@Override
	public double fixPrice() {
		setPrice(getPrice() + getPrice()*10/100); 
		return getPrice();
	}

	@Override
	public int numberofNigts() {
		int i = 0;
		i = getNumDays() - 2;
		return i;
	}

}
