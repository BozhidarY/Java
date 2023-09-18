package AbstractOOP;

public abstract class Trip {
	private String destination;
	private int numDays;
	private double price;
	
	public Trip(String destination, int numDays, double price) {
		this.destination = destination;
		this.numDays = numDays;
		this.price = price;
	}
	
	public abstract double fixPrice();

	public String getDestination() {

		return destination;
	}

	public void setDestination(String destination) {

		this.destination = destination;
	}

	public int getNumDays() {

		return numDays;
	}

	public void setNumDays(int numDays) {

		this.numDays = numDays;
	}

	public double getPrice() {

		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
