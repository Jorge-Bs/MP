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
 * 	1 Remove de la posición 0 de una lista con un elemento devuelve el elemento eliminado y la lista queda vacía
 *  2 Remove de la posición 0 de una lista no vacía devuelve el elemento eliminado, quita el elemento de la lista y  mueve el resto de elementos una posición a la izquierda
 *  3 Remove de una posición existente, devuelve el elemento borrado, se quita el elemento de la lista y mueve los elementos de la derecha una posición a la izquierda
 *  4 Remove de la última posición, devuelve el elemento borrado y quita el lemento de la lista
 *  5 Intentar realizar remove en la posición -1 lanza IndexOutOfBoundsException
 *  6 Intentar realizar remove en la posición 0 de una lista vacía, lanza IndexOutOfBoundsException
 *  7 Intentar realizar remove en la posición size() de una lista vacía, lanza IndexOutOfBoundsException
 *  8 Intentar realizar remove en la posición size() de una lista no vacía, lanza IndexOutOfBoundsException
 */
public class RemoveFromPositionTests {
	
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
	public void delOnlyItem(List list) {
		list.add("hola");
		assertTrue(list.remove(0).equals("hola"));
	}


	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delFirst(List list) {
		list.add(0, "with");
		list.add(1, "JUnit");
		list.add(2, "framework");
		int lsize = list.size();
		String s = list.toString();
		System.out.print(s);
		assertEquals("with",list.remove(0));
		assertEquals(2, lsize - 1);
		assertEquals("JUnit", list.get(0));
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delLast(List list) {
		list.add(0, "with");
		list.add(1, "JUnit");
		list.add(2, "framework");
		int lsize = list.size();
		String s = list.toString();
		System.out.print(s);
		assertEquals("framework",list.remove(2));
		assertEquals(2, lsize - 1);
		assertEquals("with", list.get(0));
		assertEquals("JUnit", list.get(1));
	}

	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void delMiddle(List list) {
		list.add(0, "with");
		list.add(1, "JUnit");
		list.add(2, "framework");
		int lsize = list.size();
		String s = list.toString();
		System.out.print(s);
		assertEquals("JUnit",list.remove(1));
		assertEquals(2, lsize - 1);
		assertEquals("with", list.get(0));
		assertEquals("framework", list.get(1));

	}
	
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void emptyList(List list) {
		list.clear();
		try {
			list.remove(0); //eliminamos el de la posición 0
			fail();
		}catch(IndexOutOfBoundsException ex) {
			assertTrue(list.isEmpty()); //la lista sigue vacía
		}
	}
	

	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testUpperBound(List list) {
		List lt= list;
		lt.add(0, "Primero");
		lt.add(1, "Primero");
		lt.add(2, "Primero");
		lt.add(3, "Primero");
		try
		{
			lt.remove(lt.size());
			fail("debería haber fallado");
		}
		catch(IndexOutOfBoundsException e)
		{
			assertTrue(true);
		}
	}
	
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testLowerBound(List list) {
		try {
			list.remove(-1);
			fail("debería haber fallado");
		}catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
		

}
