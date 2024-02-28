package uo.mp2223.util.collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

/*
 * ESCENARIOS
 * 	1 Una lista recien creada esta vacía
 *  2 Una lista queda vacía después de la operación clear
 *  3 Una lista con un elemento no está vacía
 *  4 Una lista con más de un elemento no esta vacía
 */
public class IsEmptyTests {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList<Object>()),
		      Arguments.of(new LinkedList<Object>())
		  );
		}


	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyList(List<?> list) {
		assertTrue(list.isEmpty());
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void clearedList(List<String> list) {
		list.add(0, "testing");
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void sizeOneList(List<String> list) {
		list.add(0, "testing");
		assertFalse(list.isEmpty());
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void severalItemsList(List<String> list) {
		list.add(0, "testing");
		list.add(1, "with");
		list.add(2, "JUnit");
		assertFalse(list.isEmpty());
	}
}
