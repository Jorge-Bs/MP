package uo.mp.minesweeper.game.square.square;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.exception.GameException;
import uo.mp.minesweeper.game.square.Square;

public class FlagTest {
	private Square square;
	/*Casos
	 * Flag en casilla abierta
	 * Flag en casilla cerrada
	 * Flag en casilla con bandera
	 * 
	 */
	
	@BeforeEach
	public void setUp() {
		square = new Square();
	}
	
	
	/**
	 * Given: Una casilla que esta abierta
	 * When: Se invoca al metodo
	 * Then: La casilla no se modifica, sigue abierta
	 */
	@Test
	public void flagOverOpenSquare() {
		square.open();
		assertTrue(square.isOpened());//al crea una nueva instancia, se crea cerrada, por eso se 
									// comprueba que la casilla la he cambiado a abierta, para poder probar 
									//este caso
		try {
			square.flag();
		} catch (GameException e) {
			assertTrue(true);
		}
		assertFalse(square.isFlagged());
		assertTrue(square.isOpened());
	}
	
	
	/**
	 * Given: Una casilla que está cerrada
	 * When: Se invoca al metodo
	 * Then: La casilla pasa del estado cerrado a flagged
	 * @throws GameException 
	 */
	@Test
	public void flagOverClosedSquare() throws GameException {
		square.flag();
		assertTrue(square.isFlagged());
	}
	
	/**
	 * Given: Una casilla que está con bandera
	 * When: Se invoca al metodo
	 * Then: La casilla no se modifica
	 */
	@Test
	public void flagOverFlaggedSquare() {
		try {
			square.flag();
		} catch (GameException e) {
			assertTrue(true);
		}
		assertTrue(square.isFlagged());
	}
}
