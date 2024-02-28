package uo.mp.lab11.comparator;

import java.util.Comparator;

import uo.mp.lab12.person.Person;

public class PersonBySurnameComparator implements Comparator<Person>{

	public PersonBySurnameComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Person p1, Person p2) {
		
		//	checkArePerson(o1,o2);
		
			if (p1.getName().compareTo(p2.getName()) == 0) {
				return p1.getAge() - p2.getAge();
			} else {
				return (p1.getName().compareTo(p2.getName()));
			}
		
	}

	private void checkArePerson(Object o1, Object o2) throws InvalidTypeForObject {
		if (!(o1 instanceof Person))
			throw new InvalidTypeForObject("Recibido tipo de objeto inadecuado para comparar");
				
	}

}
