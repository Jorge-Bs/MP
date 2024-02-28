package uo.mp2223.util.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;


//Escenarios
//1 Add en la posición 0 de una lista vacía añade el elemento
//2 Add en la posición 0 de una lista con varios elementos añade el elemento y mueve el resto una posición a la derecha
//3 Add en una posición intermedia de una lista añade el elemento y mueve el resto una posición a la derecha
//4 Add en la última posición de una lista con elementos añade el elemento y el último pasa a la derecha
//5 Add en la posición después del último de una lista con elementos añade el elemento al final
//6 Un elemento repetido PUEDE ser añadido y se almacena correctamente
//7 Intentar añadir  en una posición negativa, se lanza IndexOutOfBoundsException y la lista permanece igual
//8 Intentar añadir en una posicón > size(), se lanza IndexOutOfBoundsException y la lista permanece igual
//9 Intentar añadir un null, se lanza IllegalArgumentException y la lista permanece igual

public class AddInPositionTests {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}
	
	
	/**
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void emptyListAddAt0(List list) {
		list.add("Hola");
		int lsize = list.size();
		String s = list.toString() ;
		assertTrue(list.toString().equals(s));
		assertTrue(list.size()==lsize);
	}
	
	
	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void nonEmptyListAddAt0(List list) {
		list.add("Hola");
		list.add(0, "adios");
		int lsize = list.size();
		assertEquals(2,lsize);
	}
	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addFirst(List list) {
		list.add(0,"hola");
		assertTrue(list.get(0).equals("hola"));
	}

	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addLast(List list) {
		list.add("testing");
		list.add("with");
		list.add("framework");
		list.add(list.size()-1, "JUnit");
		assertTrue(list.get(list.size()-1).equals("framework"));
	}

	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addMiddle(List list) {
		list.add("testing");
		list.add("JUnit");
		list.add("framework");
		list.add(1, "with");
		assertTrue(list.get(1).equals("with"));
	}
	

	
	
	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void nullExcep(List list) {
		Integer number = 10;
		list.add(number);
		try {
			list.add(null);
			fail("debería haber fallado");
		}catch (IllegalArgumentException e) {
			assertTrue(true);
		}
		
		assertEquals(1,list.size());
		assertEquals(number,list.get(0));
	}
	

	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest 
	@MethodSource("createLists")
	public void testUpperBound(List list) {
		try {
			list.add(30,"hola");
		}catch(Exception e) {
			assertTrue(true);
		}
	}
	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest 
	@MethodSource("createLists")
	public void testLowerBound(List list) {
		list.add("with");
		list.add("JUnit");
		list.add("framework");
		try {
			list.add(-1, "framework");
		}catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	

	
	/**
	 * GIVEN: 
	 * WHEN: 
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void addRepeated(List list) {
		list.add("testing");
		list.add("with");
		list.add("JUnit");
		list.add("framework");
		list.add("framework");
		assertEquals(5,list.size());
	}
	
}
