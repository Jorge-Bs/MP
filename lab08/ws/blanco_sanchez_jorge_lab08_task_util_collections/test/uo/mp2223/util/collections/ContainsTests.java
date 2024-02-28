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
 * 	1 Una lista vacía no contiene un elemento cualquiera
 * 	2 Una lista con varios elementos no contiene al elemento cualquiera 
 * 	3 Una lista con un elemento contiene al elemento
 * 	4 Una lista con varios elemento contiene al elemento
 * 	5 Una lista vacía no contienen null
 * 	6 Una lista con elementos no contiene null
 */
public class ContainsTests {
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
	public void emptyList(List<?> list) {
		List<?> lt = list;
		String cualquiera="";
	
		assertFalse(lt.contains(cualquiera));
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void notInList(List<String> list) {
		List<String> lt = list;
		lt.add(0,"1");
		lt.add(1,"2");
		lt.add(2,"3");
		String cualquiera="4";
	
		assertFalse(lt.contains(cualquiera));
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void onlyElementInList(List<String> list) {
		list.add("Hola");
		assertTrue(list.contains("Hola"));
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void isInList(List<String> list) {
		list.add("Hola");
		list.add("s");
		list.add("America");
		assertTrue(list.contains("s"));
	}

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyListDoesNotContainNull(List<?> list) {

		assertFalse(list.contains(null));
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void nullNotInList(List<String> list) {
		list.add("A");
		list.add("B");
		assertTrue(list.contains("A"));
		assertFalse(list.contains(null));
	}
}
