package uo.mp.lab02.game.model.game2048;

import static org.junit.Assert.*;


import org.junit.Test;

import uo.mp.lab02.game.model.Game2048;
import uo.mp.lab02.game.model.util.ForTesting;
/**
 * Clase de prueba del constructor con parametro board
 * @author Jorge Blanco Sánchez
 * @version 9-02-2023 
 *
 */
public class Game2048WithBoardParamTest {
	/*
	 * Casos
	 * Positivos
	 * 1-Limite inferior
	 * 2-Limite superior
	 * 3-Dentro de limite
	 * 
	 * Negativos
	 * 4-Menor que el limite
	 * 5-Mayor que el limite
	 * 6- Null
	 * 7-No es cuadrada
	 * 8-contiene numeros que no son potencias de 2
	 */
	/**
	 * Given: Se le da como parametro un tablero 3x3, es decir, en el valor minimo
	 * When: Se estacian la clase con este constructor
	 * Then: Se acepta el tablero y crea una copia que será asignada al atributo board
	 */
	@Test
	public void minLimit() {
		Game2048 game = new Game2048(ForTesting.FULL);
		assertNotEquals(ForTesting.FULL,game.getBoardForTesting());
		assertArrayEquals(ForTesting.FULL,game.getBoardForTesting());
	}
	
	/**
	 * Given: Se le da como parametro un tablero 5x5, es decir, en el valor maximo
	 * When: Se estacian la clase con este constructor
	 * Then: Se acepta el tablero y crea una copia que será asignada al atributo board
	 */
	@Test
	public void maxLimit() {
		int[][] matrix= {{2,0,0,0,0},
						 {2,0,0,0,0},
						 {2,0,0,0,0},
						 {2,0,0,0,0},
						 {2,0,0,0,0}};
		Game2048 game = new Game2048(matrix);
		assertNotEquals(matrix,game.getBoardForTesting());
		assertArrayEquals(matrix,game.getBoardForTesting());
	}
	
	/**
	 * Given: Se le da como parametro un tablero 4x4, es decir, dentro de los limites
	 * When: Se estacian la clase con este constructor
	 * Then: Se acepta el tablero y crea una copia que será asignada al atributo board
	 */
	@Test
	public void insideLimit() {
		int[][] matrix= {{2,0,0,0},
				 		 {2,0,0,0},
				 		 {2,0,0,0},
				 		 {2,0,0,0}};
		Game2048 game = new Game2048(matrix);
		assertNotEquals(matrix,game.getBoardForTesting());
		assertArrayEquals(matrix,game.getBoardForTesting());
	}
	
	/**
	 * Given: un tablero 2x2, menor que el limite inferior
	 * when: Se estacian la clase con este constructor
	 * then: El tablero no es aceptado y salta un illegalArgumentException con el mensaje:
	 * 		"Tablero inadecuado o null"
	 */
	@Test
	public void belowLimit() {
		int[][] matrix= {{0,0},{0,0}};
		try {
			new Game2048(matrix);
			fail("Deberia haber fallado");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Tablero inadecuado o null");
		}
	}
	
	/**
	 * Given: un tablero 6x6, mayor que el limite superior
	 * when: Se estacian la clase con este constructor
	 * then: El tablero no es aceptado y salta un illegalArgumentException con el mensaje:
	 * 		"Tablero inadecuado o null"
	 */
	@Test
	public void aboveLimit() {
		int[][] matrix= {{2,0,0,0,0,0},
				 {2,0,0,0,0,0},
				 {2,0,0,0,0,0},
				 {2,0,0,0,0,0},
				 {2,0,0,0,0,0},
				 {2,0,0,0,0,0}};
		try {
			new Game2048(matrix);
			fail("Deberia haber fallado");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Tablero inadecuado o null");
		}
	}
	/**
	 * Given: parametro null
	 * when: Se estacian la clase con este constructor
	 * then: El tablero no es aceptado y salta un illegalArgumentException con el mensaje:
	 * 		"Tablero inadecuado o null"
	 */
	@Test
	public void nullMatrix() {
		try {
			new Game2048(null);
			fail("Deberia haber fallado");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Tablero inadecuado o null");
		}
	}
	
	/**
	 * Given: un tablero no cuadrado
	 * when: Se estacian la clase con este constructor
	 * then: El tablero no es aceptado y salta un illegalArgumentException con el mensaje:
	 * 		"Tablero inadecuado o null"
	 */
	@Test
	public void notSquareMatrix() {
		int[][] matrix= {{2,0,0,0},
		 		 {2,0,0,0},
		 		 {2,0,0},
		 		 {2,0,0,0}};
		try {
			new Game2048(matrix);
			fail("Deberia haber fallado");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Tablero inadecuado o null");
		}
	}
	/**
	 * Given: un tablero que no posee potencias de 2
	 * when: Se estacian la clase con este constructor
	 * then: El tablero no es aceptado y salta un illegalArgumentException con el mensaje:
	 * 		"Tablero inadecuado o null"
	 */
	@Test
	public void notPowersOfTwoMatrix() {
		int[][] matrix= {{2,0,0,0},
		 		 {2,0,0,7},
		 		 {2,0,0,0},
		 		 {2,0,0,0}};
		try {
			new Game2048(matrix);
			fail("Deberia haber fallado");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Tablero inadecuado o null");
		}
	}
}
