package uo.mp.lab02.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import uo.mp.lab02.game.model.Game2048;
import uo.mp.lab02.game.model.util.ForTesting;

/**
 * Clase de prueba del constructor 
 * @author Jorge Blanco Sánchez
 * @version 9-02-2023 
 *
 */
public class Game2048WithoutParamsTest {
	
	/**
	 * Given: nothing
	 * When: se instacia la clase con este constructor
	 * Then: se inicializa un tablero 3x3 vacio.
	 */
	@Test
	public void withoutParam() {
		Game2048 game = new Game2048();
		assertArrayEquals(ForTesting.EMPTY,game.getBoardForTesting());
	}

}
