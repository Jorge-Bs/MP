package uo.mp.lab02.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.lab02.game.model.Game2048;
import uo.mp.lab02.game.model.util.ForTesting;
/**
 * Clase de prueba del metodo isFinished()
 * @author Jorge Blanco Sánchez
 * @version 11-02-2023 
 *
 */
public class IsFinishedTest {
	Game2048 game;
	// Escenarios:
		// caso 1: Puntuacion maxima
		// caso 2: Tablero lleno
	    // caso 3: Tablero con huecos y no hay puntuacion maxima

	/**
	 * Given: Un tablero 3x3 donde hay presente la puntuación máxima
	 * When: Se llama al método
	 * Then: Retorna el boolean true ya que hay la puntuación máxima
	 */
	@Test
	public void maxPunctuation() {
		int[][] board= {{2048,0,0},{0,0,0},{0,0,0}};
		game = new Game2048(board);
		assertTrue(game.isFinished());
	}
	
	/**
	 * Given: Un tablero lleno con ningún hueco libre
	 * When: se llama al método
	 * Then: Retorna true ya que no se puede continuar jugando
	 */
	@Test
	public void completeBoard() {
		game = new Game2048(ForTesting.FULL);
		assertTrue(game.isFinished());
	}
	
	/**
	 * Given: un tablero 3x3 con un hueco presente
	 * When: se llama al método
	 * Then: retorna false ya que se pueden seguir generando valores y el usuario puede continuar
	 * 		haciendo movimientos
	 */
	@Test
	public void boardWithSpace() {
		game = new Game2048(ForTesting.EMPTY);
		assertFalse(game.isFinished());
	}
}
