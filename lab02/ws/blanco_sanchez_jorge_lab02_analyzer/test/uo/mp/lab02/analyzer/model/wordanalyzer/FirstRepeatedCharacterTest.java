package uo.mp.lab02.analyzer.model.wordanalyzer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.lab02.analyzer.model.WordAnalyzer;



public class FirstRepeatedCharacterTest {

	/*
	 * Casos de uso
	 * 
	 * 1- Caracteres repetidos consecutivos al principio
	 * 2- Caracteres repetidos consecutivos en el medio
	 * 3- Caracteres repetidos consecutivos al final
	 * 4- Varios grupos de caracteres repetidos consecutivos
	 * 5- Caracteres repetidos no consecutivos
	 * 6- Sin caracteres repetidos
	 * 
	 */
	
	/**
	 * GIVEN Analizador de palabra con caracteres repetidos consecutivos al principio
	 * WHEN se invoca firstrRepeatedCharacter
	 * THEN	devuelve el primer carácter
	 */
	
	@Test
	public void testRepeatedConsecutiveCharacterAtBeginning() {		 
		WordAnalyzer aabc = new WordAnalyzer("aabc");
		assertEquals('a',aabc.firstRepeatedCharacter());
	
	}
	
	
	/**
	 * GIVEN Analizador de palabra con caracteres repetidos consecutivos en el medio
	 * WHEN se invoca firstrRepeatedCharacter
	 * THEN devuelve el carácter repetido en medio
	 */
	@Test
	public void testRepeatedConsecutiveCharacterInMiddle() {
		WordAnalyzer abccde = new WordAnalyzer("abccde");
		assertEquals('c',abccde.firstRepeatedCharacter());		
	}
	
	/**
	 * GIVEN Analizador de palabra con caracteres repetidos consecutivos al final
	 * WHEN se invoca firstrRepeatedCharacter
	 * THEN devuelve el carácter repetido al final
	 */
	@Test
	public void testRepeatedConsecutiveCharacterAtEnd() {
		 
		WordAnalyzer abcdd = new WordAnalyzer("abcdd");
		assertEquals('d',abcdd.firstRepeatedCharacter());		
	}
	
	/**
	 * GIVEN Analizador de palabra con varios grupos de caracteres repetidos consecutivos
	 * WHEN se invoca firstrRepeatedCharacter
	 * THEN devuelve el carácter del primer grupo de caracteres repetido
	 */
	@Test
	public void testMultipleGroupsOfRepeatedCharacter() {
		 
		WordAnalyzer abbbcdd = new WordAnalyzer("abbcdd");
		assertEquals('b',abbbcdd.firstRepeatedCharacter());		
	}
	
	/**
	 * GIVEN Analizador de palabra con caracteres repetidos no consecutivos
	 * WHEN se invoca firstrRepeatedCharacter
	 * THEN devuelve 0
	 */
	@Test
	public void testRepeatedCharacterNotConsecutive() {		
		WordAnalyzer abcbcbcad = new WordAnalyzer("abcbcbcad");
		assertEquals(0,abcbcbcad.firstRepeatedCharacter());
	}
	
	
	/**
	 * GIVEN Analizador de palabra sin caracteres repetidos
	 * WHEN se invoca firstrRepeatedCharacter
	 * THEN devuelve 0
	 */	
	@Test
	public void testNoRepeatedCharacter() {
		WordAnalyzer abcdef = new WordAnalyzer("abcdef");
		assertEquals(0,abcdef.firstRepeatedCharacter());
	}	
	
	

}
