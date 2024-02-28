package uo.mp2223.util.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

/*
 * ESCENARIOS
 * 	1 El index de un elemento que no existe es -1
 * 	2 El index de null es -1
 *  3 El index de un elemento localizado en la primera posición de la lista es 0
 *  4 El index de un elemento localizado en la última posición de la lista es size() -1
 *  5 El index de un elemento colocado en medio de la lista es la posición que tiene
 *  6 En una lista con elementos repetidos, el indexOf de un elemento devuelve la posición de la primera aparición * 
 */
public class IndexOfTests {
	
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
	public void nullElem(List<Integer> list) {
		int value=list.indexOf(null);
		assertEquals(-1,value);

		list.add((Integer)10);
		assertEquals(-1,list.indexOf((Integer)11));
	}
	
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void firstInList(List<String> list) {
		list.add("Hola");
		assertEquals(0,list.indexOf("Hola"));
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void lastInList(List<String> list) {
		list.add("a");
		list.add("si");
		list.add("Hola");
		assertEquals(list.size()-1,list.indexOf("Hola"));
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void midInList(List<Integer> list) {
		List<Integer> lt=list;
		lt.add(0,1);
		lt.add(1,7);
		lt.add(2,2);
		lt.add(3,3);
		lt.add(4,4);
		assertEquals(2,lt.indexOf(2));
	}


}
