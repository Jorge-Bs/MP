package uo.mp.minesweeper.game.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.exception.GameException;
import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.model.util.ForTesting;
import uo.mp.minesweeper.game.square.Square;

public class UnveilTest {
	Board bd;
	Square[][] squares;
	
	/**
	 * Given:
	 * When: Before the test case, used to create the board
	 * Then: instance the class Board with the Square matrix created and 0 mines
	 */
	@BeforeEach
	public void setUp() {
		squares = ForTesting.fillBoardClose(4);
		
	}
	
	/**
	 * Given: Un tablero totalmente cubierto
	 * When: se invoca al metodo
	 * Then: se descubre todo el tablero
	 */
	@Test
	public void allBoardClosed() {
		bd= new Board(0,squares);
		bd.unveil();
		assertTrue(isAllDiscover());
	}
	
	
	/**
	 * Given: Un tablero totalmente cubierto y una casilla tiene bandera;
	 * When: se invoca al metodo
	 * Then: se descubre todo el tablero
	 * @throws GameException 
	 */
	@Test
	public void boardWithFlag() throws GameException {
		bd= new Board(0,squares);
		squares[0][0].flag();
		bd.unveil();
		assertTrue(isAllDiscover());
	}
	
	/**
	 * Given: Un tablero que tiene una casilla abierta
	 * When: se invoca al metodo
	 * Then: se descubre todo el tablero
	 */
	@Test
	public void boardWithOpenSquare() {
		bd= new Board(0,squares);
		squares[0][0].open();
		bd.unveil();
		assertTrue(isAllDiscover());
	}
	
	/**
	 * Comprueba si todas las casillas tiene el estado ade apertura abierto
	 * @return boolean true si lo estan, false en caso contrario
	 */
	private boolean isAllDiscover() {
		Square[][] sq = bd.getSquares();
		for(int i=0;i<sq.length;i++) {
			for(int j=0;j<sq[i].length;j++) {
				if(!sq[i][j].isOpened())
					return false;
			}
		}
		return true;
	}
}
