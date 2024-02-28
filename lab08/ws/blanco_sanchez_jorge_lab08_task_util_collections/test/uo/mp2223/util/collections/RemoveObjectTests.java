package uo.mp2223.util.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

/*
 * SCENARIOS
 * 	1 Eliminar un object en una lista vacía devuelve false y deja la lista como estaba
 * 	2 Eliminar un object existente en una lista con un elemento, devuelve true y la lista queda vacía
 *  3 Eliminar un object existente en una lista con varios elementos, devuelve true y el elemento es borrado
 *  4 Eliminar un object no existente en una lista con elementos, devuelve false y la lista no cambia
 *  5 Intentar realizar remove con null lanza IllegalArgumentException
 *  
 */	
public class RemoveObjectTests {

	public static Stream<Arguments> createLists() {
		return Stream.of(Arguments.of(new ArrayList<Object>()), Arguments.of(new LinkedList<Object>()));
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void emptyList(List<?> list) {
		Object o1 = new Object();
		
		assertFalse(list.remove(o1));
		assertTrue(list.isEmpty());
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void singleItemList(List<Object> list) {
		Object o = new Object();
		list.add(o);
		assertTrue(list.remove(o));
		assertTrue(list.isEmpty());
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void notInList(List<String> list) {
		Object o1 = new Object();
		list.add(0, "a");
		list.add(1, "b");
		list.add(2, "c");
		int lsize = list.size();
		
		assertFalse(list.remove(o1));
		assertEquals(list.size(), lsize);
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void inListFirst(List<Object> list) {
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		list.add(0, o1);
		list.add(1, o2);
		list.add(2, o3);
		
		assertTrue(list.remove(o1));
		assertTrue(list.size()==2);

	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void inListLast(List<Object> list) {
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		list.add(0, o1);
		list.add(1, o2);
		list.add(2, o3);
		
		assertTrue(list.remove(o3));
		assertTrue(list.size()==2);

	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void inListOther(List<Object> list) {
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		list.add(0, o1);
		list.add(1, o2);
		list.add(2, o3);
		
		assertTrue(list.remove(o2));
		assertTrue(list.size()==2);
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void inListRepeated(List<Object> list) {
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		list.add(0, o1);
		list.add(1, o2);
		list.add(2, o3);
		list.add(3,o3);
		
		assertTrue(list.remove(o3));
		assertTrue(list.size()==3);
	}

	/**
	 * GIVEN: WHEN: THEN:
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void nullObject(List<String> list) {
		list.add(0, "a");
		list.add(1, "b");
		list.add(2, "c");
		int lsize = list.size();
		String s = list.toString();
		
		try {
			list.remove(null);
			fail();
		}
		catch(IllegalArgumentException e) {
			assertEquals(lsize,list.size());
			assertEquals(s,list.toString());
		}
	}
}
