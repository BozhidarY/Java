package Files.Tests;

import java.util.Comparator;

public class AgeComparator6 implements Comparator<Person3> {

	@Override
	public int compare(Person3 o1, Person3 o2) {
		int firstPersonAge = o1.getAge();
		int secondPersonAge = o2.getAge();
		return firstPersonAge - secondPersonAge;
	}

}
