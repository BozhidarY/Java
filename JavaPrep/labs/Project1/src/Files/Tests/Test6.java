package Files.Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test6 {

	public static void main(String[] args) {
		List<Person> listPersons = new ArrayList<Person>();
		
		listPersons.add(new Person("Georgi", 19));
		listPersons.add(new Person("Borislav", 28));
		listPersons.add(new Person("Asen", 77));	
		
		
		Collections.sort(listPersons, new NameComparator());
		System.out.println("Sort by name:");
		for (Person p : listPersons) {
			System.out.println(p.getName() + " - " + p.getAge());
		}
		
		
		Collections.sort(listPersons, new AgeComparator());
		System.out.println("\nSort by age:");
		for (Person p : listPersons) {
			System.out.println(p.getName() + " - " + p.getAge());
		}

	}

}
