package uo.mp2223.util.collections.pl8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.List;
import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

public class Test_8_uo293697 {
	//9 Intentar añadir un null, se lanza IllegalArgumentException y la lista permanece igual
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}
	/**
	 * GIVEN: Un array list con un objeto
	 * WHEN: se invoca al método de añadir y se le pasa como argumento un null
	 * THEN: la lista lanza IllegalArgumentException, pero esta no se modifica
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
}
