package uo.mp.lab02.game.model.game2048;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.lab02.game.model.Game2048;
import uo.mp.lab02.game.model.util.ForTesting;
/**
 * Clase de prueba del metodo restart()
 * @author Jorge Blanco Sánchez
 * @version 11-02-2023 
 *
 */
public class RestartTest {
	/*
	 * Casos 
	 * Esta vacio
	 * Esta lleno
	 * Tiene un hueco libre
	 */
	/**
	 * Given: Un tablero lleno
	 * When: Se invoca al metodo
	 * Then: El tablero tiene todos sus elemetos a 0 
	 * 			excepto uno que contiene un 2
	 */
	@Test
	public void matrixIsFull() {
		Game2048 game = new Game2048(ForTesting.FULL);
		game.restart();
		assertEquals(2,ForTesting.getSum(game.getBoardForTesting()));
	}
	
	/**
	 * Given: Un tablero vacio
	 * When: Se invoca al metodo
	 * Then: El tablero tiene todos sus elemetos a 0 
	 * 			excepto uno que contiene un 2
	 */
	@Test
	public void matrixIsEmpty() {
		Game2048 game = new Game2048(ForTesting.EMPTY);
		game.restart();
		assertEquals(2,ForTesting.getSum(game.getBoardForTesting()));
	}
	
	/**
	 * Given: Un tablero con un hueco
	 * When: Se invoca al metodo
	 * Then: El tablero tiene todos sus elemetos a 0 
	 * 			excepto uno que contiene un 2
	 */
	@Test
	public void matrixHasFreeSpace() {
		int[][] matrix= {{2,2,2},{2,0,2},{2,2,2}};
		Game2048 game = new Game2048(matrix);
		game.restart();
		assertEquals(2,ForTesting.getSum(game.getBoardForTesting()));
	}

}
