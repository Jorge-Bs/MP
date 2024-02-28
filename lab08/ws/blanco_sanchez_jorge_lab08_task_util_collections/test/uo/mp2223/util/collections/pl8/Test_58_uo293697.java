package uo.mp2223.util.collections.pl8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.List;
import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

public class Test_58_uo293697 {

	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList<>()),
		      Arguments.of(new LinkedList<>())
		  );
		}
	
	
	@ParameterizedTest
	@MethodSource("createLists")
	public void delOnlyItem(List<String> list) {
		list.add("hola");
		list.add(1,"hola1");
		list.add("p");
		String value = list.remove(0);
		assertTrue(value.equals("hola"));
	}

}
