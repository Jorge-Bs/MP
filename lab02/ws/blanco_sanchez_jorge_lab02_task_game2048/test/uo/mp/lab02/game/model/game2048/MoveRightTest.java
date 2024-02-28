package uo.mp.lab02.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;

import uo.mp.lab02.game.model.Game2048;
import uo.mp.lab02.game.model.util.ForTesting;
/**
 * Clase de prueba para el metodo moveRight()
 * @author Jorge Blanco Sánchez
 * @version 11-02-2023
 *
 */
public class MoveRightTest {
	private Game2048 game;
	/*Casos
	 * Un valor por fila 0
	 * Un valor por fila 1
	 * Un valor por fila 2
	 * 
	 * Dos valores por fila 0 1
	 * Dos valores por fila 0 2
	 * Dos valores por fila 1 2
	 * 
	 * 
	 * Matriz llena
	 * 
	 * Caso 4x4 donde se compacta,suma y vuelve acompactar
	 * 
	 */
	
	
	/**
	 * Given: una matriz 3x3 que posee un unico elemento por fila
	 * en la posicion 0
	 * When: se invoca al metodo moveRight()
	 * Then: el tablero tiene en la ultima columna la suma de los elementos 
	 * 		consecutivos de las columnas anteriores y el resto 0,al no haber
	 * 		mas elementos repetidos, solo movera los elementos a la derecha
	 */
	@Test
	public void oneValuePerArrowInCero() {
		game= new Game2048(ForTesting.SEMIFULL12);
		game.moveRight();
		assertArrayEquals(ForTesting.SEMIFULL1_RIGHTCOMPACTED,game.getBoardForTesting());
	}
	
	
	/**
	 * Given: una matriz 3x3 que posee un unico elemento por fila
	 * 		  en la posicion 1
	 * When: se invoca al metodo moveRight()
	 * Then: el tablero tiene en la ultima columna la suma de los elementos 
	 * 		consecutivos de las columnas anteriores y el resto 0,al no haber
	 * 		mas elementos repetidos, solo movera los elementos a la derecha
	 */
	@Test
	public void oneValuePerArrowInOne() {
		game= new Game2048(ForTesting.SEMIFULL11);
		game.moveRight();
		assertArrayEquals(ForTesting.SEMIFULL1_RIGHTCOMPACTED,game.getBoardForTesting());
	}
	
	
	/**
	 * Given: una matriz 3x3 que posee un unico elemento por fila
	 * en la posicion 2
	 * When: se invoca al metodo moveRight()
	 * Then: el tablero tiene en la ultima columna la suma de los elementos 
	 * 		consecutivos de las columnas anteriores y el resto 0,al no haber
	 * 		mas elementos repetidos, solo movera los elementos a la derecha
	 */
	@Test
	public void oneValuePerArrowInTwo() {
		game= new Game2048(ForTesting.SEMIFULL13);
		game.moveRight();
		assertArrayEquals(ForTesting.SEMIFULL1_RIGHTCOMPACTED,game.getBoardForTesting());
	}
	
	/**
	 * Given: una matriz 3x3 que posee dos elemento por fila
	 * en la posicion 0 y 1
	 * When: se invoca al metodo moveRight()
	 * Then: el tablero el tablero tiene en las ultimas columnas la suma de los elementos 
	 * 		consecutivos de las columnas anteriores y el resto 0
	 */
	@Test
	public void twoValuesPerArrowInCeroAndOne() {
		game= new Game2048(ForTesting.SEMIFULL22);
		game.moveRight();
		assertArrayEquals(ForTesting.SEMIFULL2_RIGHTCOMPACTED,game.getBoardForTesting());
	}
	
	/**
	 * Given: una matriz 3x3 que posee dos elemento por fila
	 * en la posicion 0 y 2
	 * When: se invoca al metodo moveRight()
	 * Then: el tablero el tablero tiene en las ultimas columnas la suma de los elementos 
	 * 		consecutivos de las columnas anteriores y el resto 0
	 */
	@Test
	public void twoValuesPerArrowInCeroAndTwo() {
		game= new Game2048(ForTesting.SEMIFULL23);
		game.moveRight();
		assertArrayEquals(ForTesting.SEMIFULL2_RIGHTCOMPACTED,game.getBoardForTesting());
	}
	
	/**
	 * Given: una matriz 3x3 que posee dos elemento por fila
	 * en la posicion 1 y 2
	 * When: se invoca al metodo moveRight()
	 * Then: el tablero el tablero tiene en las ultimas columnas la suma de los elementos 
	 * 		consecutivos de las columnas anteriores y el resto 0
	 */
	@Test
	public void twoValuesPerArrowInOneAndTwo() {
		game= new Game2048(ForTesting.SEMIFULL21);
		game.moveRight();
		assertArrayEquals(ForTesting.SEMIFULL2_RIGHTCOMPACTED,game.getBoardForTesting());
	}
	
	
	/**
	 * Given un tablero 3x3 con 2 valores iguales de fila
	 * When se invoca moveRight()
	 * then el tablero tiene en las ultimas columnas la suma de los elementos 
	 * 		consecutivos de las columnas anteriores y el resto 0
	 */
	@Test
	public void testMoveRightHalfMatrix() {
		int[][] initial= {{2,0,2},{2,2,0},{4,2,2}};
		int[][] expected = {{0,0,4},{0,0,4},{0,4,4}};
		game = new Game2048(initial);
		game.moveRight();
		assertArrayEquals(expected,game.getBoardForTesting());
	}
	
	/**
	 * Given: Un tablero 3x3 con una matriz llena
	 * When: Cuando se invoca al metodo
	 * Then: La matriz es compactada a la derecha sumado los elemtos iguales
	 * 		y se vuelve a compacatar a la derecha para terminar,
	 * 		la matriz tendra los elementos sumados en las posiciones
	 * 		mas proximas a la derecha,al estar llena la matriz resultante
	 * 		sera igual a la de partida
	 */
	@Test
	public void testFullMatrix() {
		game= new Game2048(ForTesting.FULL);
		game.moveRight();
		assertArrayEquals(ForTesting.FULL,game.getBoardForTesting());
	}
	
	
	/**
	 * Given: Una matriz 4x4 con un hueco libre por fila
	 * When: Cuando se invoca al metodo
	 * Then: La matriz será compactada, se sumaran los elementos
	 * 		repetido y al haber un hueco entre elementos se volvera a
	 * 		compactar
	 * 
	 */
	@Test
	public void fourSquareMatrixWith() {
		int[][] initial= {{2,2,0,2},{2,2,0,2},{2,0,2,2},{2,0,2,2}};
		int[][] expected = {{0,0,4,2},{0,0,4,2},{0,0,4,2},{0,0,4,2}};
		game = new Game2048(initial);
		game.moveRight();
		assertArrayEquals(expected, game.getBoardForTesting());
	}
}
