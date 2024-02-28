package uo.mp2223.util.collections;


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
 * 	1 Realizar get en una posición cualquiera de una lista no vacía retorna el elemento y la lista perpanece igual
 * 	2 Intentar realizar get en la posición 0 de una lista vacía, lanza IndexOutOfBoundsException
 * 	3 Intentar realizar get en la posición -1 de una lista vacía, lanza IndexOutOfBoundsException
 * 	4 Intentar realizar get en la posición -1 de una lista con elementos, lanza IndexOutOfBoundsException
 * 	5 Intentar realizar get en la posición size() de una lista con elementos, lanza IndexOutOfBoundsException
 */
public class GetTests {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList<>()),
		      Arguments.of(new LinkedList<>())
		  );
		}


	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void inList(List<?> list) {
		list.clear(); //vaciamos la lista
		try {
			list.get(0);
			fail();
		}catch(Exception ex) {
			assertTrue(list.isEmpty());
		}
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testEmpty(List<?> list) {
		list.clear(); //vaciamos la lista
		try {
			list.get(-1);
			fail();
		}catch(Exception ex) {
			assertTrue(list.isEmpty());
		}
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists") 
	public void testUpper(List<?> list) {
		try {
			list.get(-1);
			fail();
		}catch(Exception ex) {
			assertTrue(list.isEmpty()); //la lista sigue sin estar vacía
		}
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyMinusOne(List<?> list) {
		try {
			list.get(list.size());
			fail();
		}catch(Exception ex) {
			assertTrue(list.isEmpty()); //la lista sigue sin estar vacía
		}
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testLower(List<String> list) {
		list.add("hola");
		list.get(0);
	}
}
