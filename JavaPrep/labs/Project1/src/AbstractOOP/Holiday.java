package AbstractOOP;

public class Holiday extends Trip{
	private String name;
	
	public Holiday(String destination, int numDays, double price, String name) {
		super(destination,numDays,price);
		this.name = name;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public double fixPrice() {
		setPrice(getPrice() + getPrice()*40/100); 
		return getPrice();
	}
}
