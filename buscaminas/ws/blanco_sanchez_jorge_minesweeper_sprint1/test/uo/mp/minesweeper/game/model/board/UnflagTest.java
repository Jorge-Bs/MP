package uo.mp.minesweeper.game.model.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.game.model.Board;
import uo.mp.minesweeper.game.model.Square;
import uo.mp.minesweeper.game.model.util.ForTesting;

public class UnflagTest {
	Board bd;
	Square[][] squares;
	
	@BeforeEach
	public void setUp() {
		squares = ForTesting.fillBoardClose();
	}
	
	
	/**
	 * Given: Un tablero cerrado con bandera en la posicion 00 que tiene mina
	 * When: Se invoca al metodo
	 * Then: Se quita la bandera, aumenta en uno el marcador de banderas
	 */
	@Test
	public void unflagWithSquareFlag() {
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
		
		bd.unflag(0, 0);
		
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
		
		bd.unflag(0, 0);
		
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
		
		bd.unflag(0, 0);
		bd.unflag(0, 0);
		
		assertEquals(0,bd.getNumberOfFlagsLeft());
		assertEquals(0,bd.getNumberOfMinesLeft());
		assertFalse(squares[0][0].isFlagged());
	}

}
