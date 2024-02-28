package uo.mp2223.util.collections.pl8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import uo.mp2223.util.collections.List;
import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

public class Test_48_49_uo293697 {
	 //* 	1 El index de un elemento que no existe es -1
	 //* 	2 El index de null es -1
	public static Stream<Arguments> createLists() {
		  return Stream.of(
		      Arguments.of(new ArrayList()),
		      Arguments.of(new LinkedList())
		  );
		}
	
	//caso 1 y 2, no hay cabecera de los dos en en la clase
	/**
	 * GIVEN: 
	 * WHEN:    
	 * THEN: 
	 */
	@ParameterizedTest
	@MethodSource("createLists")
	public void nullElem(List list) {
		int value=list.indexOf(null);
		assertEquals(-1,value);

		list.add((Integer)10);
		assertEquals(-1,list.indexOf((Integer)11));
		
	}
}
