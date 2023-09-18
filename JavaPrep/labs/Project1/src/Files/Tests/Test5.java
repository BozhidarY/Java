package Files.Tests;

import java.util.LinkedList;
import java.util.Queue;

public class Test5 {

	public static void main(String[] args) {
		Queue<String> cars = new LinkedList<String>();
		cars.offer("Honda");
		cars.offer("Opel");
		cars.offer("Mazda");
		cars.offer("Audi");

		System.out.println("1 - " + cars.peek()); 
		while (cars.size() > 0) {
			String msg = cars.poll();
			System.out.println(msg);
		}
		System.out.println(cars.size());

	}

}
