package Files.Tests;

import java.util.Stack;

public class Test4 {

	public static void main(String[] args) {
		
		Stack<String> cars = new Stack<String>();
		
		cars.push("Honda");
		cars.push("Opel");
		cars.push("Mazda");
		cars.push("Audi");
		
		System.out.println("cars.size() :"+cars.size());
		
		System.out.println(cars.peek());
		
		System.out.println(cars.pop());
		System.out.println("cars.size() :"+cars.size());
		cars.clear(); 
		
		System.out.println("cars.size() :"+cars.size());

	}

}
