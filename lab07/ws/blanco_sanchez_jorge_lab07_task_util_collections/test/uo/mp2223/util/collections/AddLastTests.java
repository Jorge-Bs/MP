package uo.mp2223.util.collections;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

public class AddLastTests {
	
	// SCENARIOS
	//1 Add en una lista vacía añade el elemento y devuelve true
	//2 Add en una lista con varios elementos, añade el elemento en la última posición y devuelve true
	//3 Se puede añadir un elemento repetido
	//4 Intentar añadir un null, se lanza IllegalArgumentException y la lista permanece igual

	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}

	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")  
	public void nullElement(List list) {
		try {
			list.add(null);
			fail();
		} catch (IllegalArgumentException ex) {
			assertTrue(true);
		}
	}

	@ParameterizedTest@MethodSource("createLists") 
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	public void emptyList(List list) {
		list.add("list");
		assertTrue(list.size() == 1);
		assertTrue(list.get(0).equals("list"));
	}
	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists") 
	public void notNullElement(List list) {
		list.add(0, "list");
		list.add(1, "with");
		list.add(2, "different");
		int lsize = list.size();
		list.add("elements");
		assertTrue(list.size() == lsize + 1);
	}

	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")  
	public void notNullRepeatedElement(List list) {		
		list.add(0, "list");
		list.add(1, "with");
		list.add(2, "repeated");
		list.add(3, "elements");
		int lsize = list.size();
		list.add("reapeted");
		assertTrue(list.size() == lsize + 1);
	}
	


}
