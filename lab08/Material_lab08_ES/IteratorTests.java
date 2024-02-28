package uo.mp2223.util.collections;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;



public class IteratorTests {



	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}
	
	
	
	/**
	 * GIVEN: an empty list 
	 * THEN: hasNext devuelve false
	 */
	
	@ParameterizedTest
	@MethodSource("createLists")
	public void emptyListWhithHasNext(List list) {
		Iterator<Object> it = list.iterator();
		assertFalse(it.hasNext());		
	}
	
	
	/**
	 * GIVEN: an empty list 
	 * THEN: next lanza NoSuchElementExeption
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void EmptyListWhithNext(List list) {
		Iterator<Object> it = list.iterator();
		try {
			it.next();
		} catch (NoSuchElementException e ) {
			assertTrue(true);
		}
	}
	

	/**
	 * GIVEN: non empty list 
	 * THEN: next devuelve los valores
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void someElementsList(List list) {
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator<Object> it = list.iterator();
		
		assertTrue(it.hasNext());
		assertEquals("A", it.next());
		assertEquals("B", it.next());
		assertEquals("C", it.next());
		
		try {
			it.next();
		} catch (NoSuchElementException e ) {
			assertTrue(true);
		}
	}
		
}
