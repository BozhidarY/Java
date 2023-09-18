package Files.Tests;

import java.util.Comparator;

public class NameComparator6 implements Comparator<Person6> {

	@Override
	public int compare(Person6 p1, Person6 p2) {
		String firstPersonName = p1.getName().toUpperCase();
		String secondPersonName = p2.getName().toUpperCase();
		return firstPersonName.compareTo(secondPersonName);		
	}

}
