package uo.mp.lab02.game.model.game2048;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import uo.mp.lab02.game.model.Game2048;
import uo.mp.lab02.game.model.util.ForTesting;
/**
 * Clase de prueba del metodo next()
 * @author Jorge Blanco Sánchez
 * @version 11-02-2023 
 *
 */
public class NextTest {
	/*
	 * Casos
	 * Matriz llena
	 * 
	 * Matriz vacia
	 * 
	 * Matriz con un hueco
	 */
	
	/**
	 * Given: Un tablero lleno
	 * When: Se invoca al metodo
	 * Then: No se genera nigun 2 dentro del tablero
	 */
	@Test
	public void matrixIsFull() {
		Game2048 game = new Game2048(ForTesting.FULL);
		game.next();
		assertEquals(98,ForTesting.getSum(game.getBoardForTesting()));
	}
	
	/**
	 * Given: Un tablero vacio
	 * When: Se invoca al metodo
	 * Then:  Se genera un 2 dentro del tablero
	 */
	@Test
	public void matrixIsEmpty() {
		Game2048 game = new Game2048(ForTesting.EMPTY);
		game.next();
		assertEquals(2,ForTesting.getSum(game.getBoardForTesting()));
	}
	
	/**
	 * Given: Un tablero con un espacio disponible
	 * When: Se invoca al metodo
	 * Then: se genera un 2 dentro del tablero, en ese hueco vacio
	 */
	@Test
	public void matrixHasFreeSpace() {
		int[][] matrix= {{2,2,2},{2,0,2},{2,2,2}};
		Game2048 game = new Game2048(matrix);
		game.next();
		assertEquals(18,ForTesting.getSum(game.getBoardForTesting()));
	}
}
