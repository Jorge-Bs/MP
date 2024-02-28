package uo.mp.minesweeper.game.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.exception.GameException;
import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.model.util.ForTesting;
import uo.mp.minesweeper.game.square.Square;

public class UnflagTest {
	Board bd;
	Square[][] squares;
	
	@BeforeEach
	public void setUp() {
		squares = ForTesting.fillBoardClose(4);
	}
	
	
	/**
	 * Given: Un tablero cerrado con bandera en la posicion 00 que tiene mina
	 * When: Se invoca al metodo
	 * Then: Se quita la bandera, aumenta en uno el marcador de banderas
	 * @throws GameException 
	 */
	@Test
	public void unflagWithSquareFlag() throws GameException {
		bd= new Board(1, squares);
		squares[0][0].putMine();
		bd.flag(0, 0);
		
		assertEquals(0,bd.getNumberOfFlagsLeft());
		assertEquals(0,bd.getNumberOfMinesLeft());
		
		bd.unflag(0, 0);
		
		assertEquals(1,bd.getNumberOfFlagsLeft());
		assertEquals(1,bd.getNumberOfMinesLeft());
		assertFalse(squares[0][0].isFlagged());
	}
	
	/**
	 * Given: Un tablero sin ninguna casilla con bandera, se intenta desmarcar un casilla que tiene mina
	 * When: se invoca al metodo
	 * Then: la casilla no se modifica y el marcador no aumenta
	 */
	@Test
	public void unflagSquareMinedWithouFlag() {
		bd= new Board(1, squares);
		squares[0][0].putMine();
		
		assertEquals(1,bd.getNumberOfFlagsLeft());
		assertEquals(1,bd.getNumberOfMinesLeft());
		
		try {
			bd.unflag(0, 0);
		} catch (GameException e) {
			assertTrue(true);
		}
		
		assertEquals(1,bd.getNumberOfFlagsLeft());
		assertEquals(1,bd.getNumberOfMinesLeft());
		assertFalse(squares[0][0].isFlagged());
	}
	
	
	/**
	 * Given: Un tablero sin ninguna casilla con bandera, 
	 * When: se invoca al metodo
	 * Then: la casilla no se modifica y el marcador no aumenta
	 */
	@Test
	public void unflagWithoutFlag() {
		bd= new Board(0, squares);
		
		assertEquals(0,bd.getNumberOfFlagsLeft());
		assertEquals(0,bd.getNumberOfMinesLeft());
		
		try {
			bd.unflag(0, 0);
		} catch (GameException e) {
			assertTrue(true);
		}
		
		assertEquals(0,bd.getNumberOfFlagsLeft());
		assertEquals(0,bd.getNumberOfMinesLeft());
		assertFalse(squares[0][0].isFlagged());
	}
	
	
	/**
	 * Given: Un tablero sin ninguna casilla con bandera, 
	 * When: se invoca al metodo dos veces
	 * Then: la casilla no se modifica y el marcador no aumenta
	 */
	@Test
	public void unflagTwice() {
		bd= new Board(0, squares);
		
		assertEquals(0,bd.getNumberOfFlagsLeft());
		assertEquals(0,bd.getNumberOfMinesLeft());
		
		try {
			bd.unflag(0, 0);
		} catch (GameException e) {
			assertTrue(true);
		}
		try {
			bd.unflag(0, 0);
		} catch (GameException e) {
			assertTrue(true);
		}
		
		assertEquals(0,bd.getNumberOfFlagsLeft());
		assertEquals(0,bd.getNumberOfMinesLeft());
		assertFalse(squares[0][0].isFlagged());
	}

}
