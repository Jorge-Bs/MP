package uo.mp2223.util.collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

/*
 * ESCENARIOS
 * Clear en una lista vacía no tiene efecto
 * Clear en una lista con un elemento deja la lista vacía
 * Clear en una lista con varios elementos deja la lista vacía
 */
public class ClearTests {
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList<>()),
		      Arguments.of(new LinkedList<>())
		  );
		}


	/**
	 * Given: an empty list
	 * When: clear() is invoked
	 * Then: the list remains empty
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void test(List<?> list) {
		list.clear();
		
		assertTrue( list.size() == 0 );
	}
	
	/**
	 * Given: a list with just one element
	 * When: clear() is invoked
	 * Then: the list is empty
	 */
	@ParameterizedTest@MethodSource("createLists")
	public void testClearWithOne(List<String> list) {
		list.add( "testing" );
		
		list.clear();
		
		assertTrue( list.size() == 0 );
		assertTrue( list.contains( "testing" ) == false );
	}
	
	/**
	 * Given: a list with several elements
	 * When: clear() is invoked
	 * Then: the list is empty
	 */
	@ParameterizedTest 
	@MethodSource("createLists")
	public void testClearWithSeveral(List<String> list) {
		list.add( "testing" );
		list.add( "with" );
		list.add( "JUnit" );
		list.add( "framework" );

		list.clear();
		
		assertTrue( list.size() == 0 );
		assertTrue( list.contains( "testing" ) == false );
	}

}
