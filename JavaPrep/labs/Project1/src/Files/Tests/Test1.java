package Files.Tests;

import java.util.LinkedList;

public class Test1 {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();		
		l.add("This");
		l.add("is");
		l.add(6);
		l.add("!");
		System.out.println("Contents: " + l);
		l.remove("!");
		l.remove(2);
		System.out.println("Contents: " + l);
		l.removeFirst();
		l.removeLast();
		System.out.println("Contents: " + l);
		
	}

}
