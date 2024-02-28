package uo.mp.lab02.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.lab02.game.model.Game2048;
import uo.mp.lab02.game.model.util.ForTesting;

/**
 * Clase de prueba del constructor con parametro size
 * @author Jorge Blanco Sánchez
 * @version 9-02-2023 
 *
 */
public class Game2048WithIntParamTest {
	/*
	 * Casos
	 * 1-Limite inferior
	 * 2-Limite superior
	 * 3-Dentro de limite
	 * 
	 * 4-Menor que limite
	 * 5-Mayor que limite
	 * 
	 */
	/**
	 * Given: Se le da como parametro el int 3, es decir, en el valor minimo
	 * When: Se estacian la clase con este constructor
	 * Then: Se acepta el tablero y crea un tablero 3x3
	 */
	@Test
	public void minLimit() {
		Game2048 game = new Game2048(Game2048.MIN);
		assertArrayEquals(ForTesting.EMPTY,game.getBoardForTesting());
	}
	/**
	 * Given: Se le da como parametro el int 5, es decir, en el valor maximo
	 * When: Se estacian la clase con este constructor
	 * Then: Se acepta el tablero y crea un tablero 5x5
	 */
	@Test
	public void maxLimit() {
		int[][] matrix= {{0,0,0,0,0},
						 {0,0,0,0,0},
						 {0,0,0,0,0},
						 {0,0,0,0,0},
						 {0,0,0,0,0}};
		Game2048 game = new Game2048(Game2048.MAX);
		assertArrayEquals(matrix,game.getBoardForTesting());
	}
	
	/**
	 * Given: Se le da como parametro el int 4, es decir, dentro de limites
	 * When: Se estacian la clase con este constructor
	 * Then: Se acepta el tablero y crea un tablero 4x4
	 */
	@Test
	public void insideLimit() {
		int[][] matrix= {{0,0,0,0},
						 {0,0,0,0},
						 {0,0,0,0},
						 {0,0,0,0}};
		Game2048 game = new Game2048(4);
		assertArrayEquals(matrix,game.getBoardForTesting());
	}
	/**
	 * Given: un tablero 2x2, menor que el limite inferior
	 * when: Se estacian la clase con este constructor
	 * then: El parametro no es aceptado, pero se inicializa un tablero 3x3
	 */
	@Test
	public void belowLimit() {
		Game2048 game = new Game2048(Game2048.MIN-1);
		assertArrayEquals(ForTesting.EMPTY,game.getBoardForTesting());
	}
	/**
	 * Given: un tablero 6x6, mayor que el limite superior
	 * when: Se estacian la clase con este constructor
	 * then: El parametro no es aceptado, pero se inicializa un tablero 3x3
	 */
	@Test
	public void aboveLimit() {
		Game2048 game = new Game2048(Game2048.MAX+1);
		assertArrayEquals(ForTesting.EMPTY,game.getBoardForTesting());
	}
}
