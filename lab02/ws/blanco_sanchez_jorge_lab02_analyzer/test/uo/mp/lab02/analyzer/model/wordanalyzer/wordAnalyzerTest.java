package uo.mp.lab02.analyzer.model.wordanalyzer;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.lab02.analyzer.model.WordAnalyzer;

public class wordAnalyzerTest {
	/*
	 * Casos
	 * palabra cualquiera se crea el analizador
	 * null como palabra salta excepcion
	 * palabra vacia salta excepcion
	 * palabra con multiples espacios en blanco salta excepcion
	 */
	/**
	 * Given
	 * When se crea eel analizador pasandole una cadena valida
	 * then se crea en el estado inicial correcto
	 */
	
	@Test
	public void someCharactersWord() {
		WordAnalyzer word= new WordAnalyzer("axbdr");
		assertNotNull(word);
		assertEquals("axbdr",word.toString());
	}
}
