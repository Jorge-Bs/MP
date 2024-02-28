package uo.mp2223.util.collections.pl8;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.List;
import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

public class Test_62_uo293697 {
	//5 Intentar realizar remove en la posición -1 lanza IndexOutOfBoundsException
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}
	/**
	 * GIVEN: Una lista 
	 * WHEN:   se elimina en posicion -1
	 * THEN: se lanza un IndexOutOfBoundsException
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void testLowerBound(List list) {
		try {
			list.remove(-1);
			fail("debería haber fallado");
		}catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
}
