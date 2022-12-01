package AbstractOOP;

public class Main {
	public static void main(String[] args) {
		Excursion exc = new Excursion("Vegas", 20, 400, 4);
		System.out.println(exc.getDestination() + exc.getNumDays());
		
//		exc.numberofNigts();
		System.out.println(exc.numberofNigts());
	}
}
