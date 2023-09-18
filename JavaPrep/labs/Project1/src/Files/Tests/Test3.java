package Files.Tests;

import java.util.ArrayList;

public class Test3 {

	public static void main(String[] args) {

		Person3 p1 = new Person3("Ivan", 18);
		Person3 p2 = new Person3("Ivo", 22);
		Person3 p3 = new Person3("Georgi", 25);

		ArrayList<Person3> list1 = new ArrayList<Person3>();
		list1.add(p1);
		list1.add(p2);
		list1.add(p3);
		System.out.println("List1 size: " + list1.size());

		ArrayList<Person> list2 = new ArrayList<Person>();

		list2.addAll(list1);

		for (Person p : list2) {
			System.out.println("Person name: " + p.getName());
		}


		list1.removeAll(list2);
		System.out.println("List1 size: " + list1.size());

		list2.remove(1);
		System.out.println("List2 size: " + list2.size());

		Person[] persons = list2.toArray(new Person[list2.size()]);
		for (Person p : persons) {
			System.out.println("Person name: " + p.getName());
		}
		ArrayList<Person> list3 = new ArrayList<Person>();
		for (int i = 0; i < persons.length; i++) {
			list3.add(persons[i]);
		}

		is hee the best in this game and he had nowhere

	}

}
