package uo.mp2223.util.collections.pl8;

import static org.junit.jupiter.api.Assertions.assertFalse;


import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.List;
import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

public class Test_17_uo293697 {
	
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList<>()),
		      Arguments.of(new LinkedList<>())
		  );
		}
	
	
	//5 Una lista vacía no contienen null
	/**
	 * Given: una lista vacia
	 * When: se ejecuta el metodo contains con null
	 * Then: la lista no puede tener elementos vacios
	 * 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void emptyListDoesNotContainNull(List<?> list) {
		assertFalse(list.contains(null));
	}
	
	
	
}
