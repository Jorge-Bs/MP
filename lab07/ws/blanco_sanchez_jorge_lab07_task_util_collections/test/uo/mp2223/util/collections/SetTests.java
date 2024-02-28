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

/*
 * ESCENARIOS
 * 	1 Set en la posición 0 de una lista con varios elementos, cambia el valor de la posición n y devuelve el valor anterior de esa posición
 * 	2 Set en la posición n de una lista con un elemento cambia el valor y devuelve el valor anterior de esa posición 
 * 	3 Intentar realizar set en la posición -1 de una lista vacía, lanza IndexOutOfBoundsException
 * 	4 Intentar realizar set en la posición size() de una lista vacía, lanza IndexOutOfBoundsException
 * 	5 Intentar realizar set en la posición -1 de una lista con elementos, lanza IndexOutOfBoundsException
 * 	6 Intentar realizar set en la posición size() de una lista con elementos, lanza  IndexOutOfBoundsException
 */
public class SetTests {
	
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
	public void setFirst(List list) {
		list.add("with");
		list.add("junit");
		list.add("framework");
		int previousSize = list.size();
		String message = "java";
		assertEquals("with",list.set(0,message));
		assertEquals(message,list.get(0));
		assertTrue(previousSize == list.size());
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setFinal(List list) {
		list.add("with");
		list.add("junit");
		list.add("framework");
		int previousSize = list.size();
		String message = "java";
		assertEquals("framework",list.set(list.size()-1,message));
		assertEquals(message,list.get(previousSize-1));
		assertTrue(previousSize == list.size());
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void setMiddle(List list) {
		list.add("with");
		list.add("junit");
		list.add("framework");
		int previousSize = list.size();
		String message = "java";
		assertEquals("junit",list.set(1,message));
		assertEquals(message,list.get(1));
		assertTrue(previousSize == list.size());

	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testEmpty(List list) {
		String message = "java";

		try {
			list.set(0,message);
			fail("Debería haber lanzado una excepción");
		}catch(Exception ex) {

			assertTrue(0 == list.size());
		}
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testUpper(List list) {
		String message = "java";
		try {
			list.set(list.size(),message);
			fail("Debería haber lanzado una excepción");
		}catch(Exception ex) {
			assertTrue(0 == list.size());
		}

		
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testLower(List list) {
		String message = "java";
		try {
			list.set(-1,message);
			fail("Debería haber lanzado una excepción");
		}catch(Exception ex) {
			assertTrue(0 == list.size());
		}
	}



}
