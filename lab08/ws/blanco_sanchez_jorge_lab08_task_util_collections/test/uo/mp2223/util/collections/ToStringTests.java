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
 * 	1 Una lista vacía devuelve []
 *  2 Una lista con un elmento devuelve [elemento]
 * 	3 Una lista con 3 elementos devuelve [elemento1, elemento2, elemento3]
 */
public class ToStringTests {
	
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
	@ParameterizedTest
	@MethodSource("createLists")
	public void emptylist(List<?> list) {
		String expected = "[]";
		assertEquals(expected,list.toString());
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void one(List<String> list) {
		list.add(0, "with");
		assertEquals("[with]",list.toString());
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void some(List<String> list) {
		list.add(0, "with");
		list.add(1, "JUnit");
		list.add(2, "framework");
		assertEquals("[with, JUnit, framework]",list.toString());
	}

}
