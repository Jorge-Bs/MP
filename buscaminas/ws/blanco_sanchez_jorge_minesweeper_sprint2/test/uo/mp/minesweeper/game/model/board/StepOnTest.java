package uo.mp.minesweeper.game.model.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.Square;
import uo.mp.minesweeper.game.model.util.ForTesting;

public class StepOnTest {

	private Square[][] sq;
	private Board bd;
	
	@BeforeEach
	public void setUp() {
		sq= ForTesting.fillBoardClose();
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
		
		bd.stepOn(0, 0);
		assertTrue(sq[0][0].isOpened());
		
		assertFalse(bd.hasExploded());
	}
	
	/**
	 * Given: un tablero sobre una casilla con mina y bandera
	 * When: se invoca al metodo sobre esta casilla
	 * Then: no se modifica el estado de la casilla
	 */
	@Test
	public void steepOnMinedAndFlaggedSquare() {
		bd = new Board(2,sq);
		sq[0][0].putMine();
		sq[0][0].flag();
		
		bd.stepOn(0, 0);
		assertFalse(sq[0][0].isOpened());
		assertTrue(sq[0][0].isFlagged());
		
		assertFalse(bd.hasExploded());
	}
	
	
	/**
	 * Given: un tablero sobre una casilla bandera
	 * When: se invoca al metodo sobre esta casilla
	 * Then: no se modifica el estado de la casilla
	 */
	@Test
	public void steepOnFlaggedSquare() {
		bd = new Board(2,sq);
		sq[0][0].flag();
		
		bd.stepOn(0, 0);
		assertFalse(sq[0][0].isOpened());
		assertTrue(sq[0][0].isFlagged());
		
		assertFalse(bd.hasExploded());
	}
	
	
	/**
	 * Given: un tablero sobre una casilla con mina 
	 * When: se invoca al metodo sobre esta casilla
	 * Then: se abre la casilla y el estado del tablero pasa a explotado
	 */
	@Test
	public void steepOnMinedSquare() {
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
	 */
	@Test
	public void steepOnValueSquare() {
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
	 */
	@Test
	public void steepOnCeroValueSquare() {
		bd = new Board(2,sq);
		sq[0][0].setValue(0);
		
		bd.stepOn(0, 0);
		assertTrue(sq[0][0].isOpened());
		assertFalse(bd.hasExploded());
	}
	
	

}
