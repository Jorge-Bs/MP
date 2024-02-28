package uo.mp.minesweeper.game.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.exception.GameException;
import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.model.util.ForTesting;
import uo.mp.minesweeper.game.square.Square;

public class StepOnTest {

	private Square[][] sq;
	private Board bd;
	
	@BeforeEach
	public void setUp() {
		sq= ForTesting.fillBoardClose(4);
	}
	
	/**
	 * Given: un tablero sobre una casilla ya descubierta
	 * When: se invoca al metodo sobre esta casilla
	 * Then: no se modifica el estado de la casilla
	 */
	@Test
	public void steepOnOpenSquare() {
		bd = new Board(2,sq);
		sq[0][0].open();
		
		try {
			bd.stepOn(0, 0);
		} catch (GameException e) {
			assertTrue(true);
		}
		assertTrue(sq[0][0].isOpened());
		
		assertFalse(bd.hasExploded());
	}
	
	/**
	 * Given: un tablero sobre una casilla con mina y bandera
	 * When: se invoca al metodo sobre esta casilla
	 * Then: no se modifica el estado de la casilla
	 * @throws GameException 
	 */
	@Test
	public void steepOnMinedAndFlaggedSquare() throws GameException {
		bd = new Board(2,sq);
		sq[0][0].putMine();
		sq[0][0].flag();
		
		try {
			bd.stepOn(0, 0);
		} catch (GameException e) {
			assertTrue(true);
		}
		assertFalse(sq[0][0].isOpened());
		assertTrue(sq[0][0].isFlagged());
		
		assertFalse(bd.hasExploded());
	}
	
	
	/**
	 * Given: un tablero sobre una casilla bandera
	 * When: se invoca al metodo sobre esta casilla
	 * Then: no se modifica el estado de la casilla
	 * @throws GameException 
	 */
	@Test
	public void steepOnFlaggedSquare() throws GameException {
		bd = new Board(2,sq);
		sq[0][0].flag();
		
		try {
			bd.stepOn(0, 0);
		} catch (GameException e) {
			assertTrue(true);
		}
		assertFalse(sq[0][0].isOpened());
		assertTrue(sq[0][0].isFlagged());
		
		assertFalse(bd.hasExploded());
	}
	
	
	/**
	 * Given: un tablero sobre una casilla con mina 
	 * When: se invoca al metodo sobre esta casilla
	 * Then: se abre la casilla y el estado del tablero pasa a explotado
	 * @throws GameException 
	 */
	@Test
	public void steepOnMinedSquare() throws GameException {
		sq[0][0].putMine();
		bd = new Board(2,sq);
		
		
		bd.stepOn(0, 0);
		assertTrue(sq[0][0].isOpened());
		assertTrue(bd.hasExploded());
	}
	
	
	/**
	 * Given: un tablero sobre una casilla valor numerico entre[1-8]
	 * When: se invoca al metodo sobre esta casilla
	 * Then: se abre la casilla 
	 * @throws GameException 
	 */
	@Test
	public void steepOnValueSquare() throws GameException {
		sq[0][0].setValue(4);
		bd = new Board(2,sq);
		
		
		bd.stepOn(0, 0);
		assertTrue(sq[0][0].isOpened());
		assertFalse(bd.hasExploded());
	}
	
	
	/**
	 * Given: un tablero sobre una casilla valor numerico 0
	 * When: se invoca al metodo sobre esta casilla
	 * Then: se abre la casilla 
	 * @throws GameException 
	 */
	@Test
	public void steepOnCeroValueSquare() throws GameException {
		bd = new Board(2,sq);
		sq[0][0].setValue(0);
		
		bd.stepOn(0, 0);
		assertTrue(sq[0][0].isOpened());
		assertFalse(bd.hasExploded());
	}
	
	

}
