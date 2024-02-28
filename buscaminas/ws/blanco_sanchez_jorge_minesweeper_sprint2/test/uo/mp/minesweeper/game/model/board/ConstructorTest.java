package uo.mp.minesweeper.game.model.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.game.Board;

public class ConstructorTest {

	/**
	 * Given: Nothing
	 * When: se instacian la clase, con parametros width, height and percentage
	 * Then: se comprueba que el tablero creado tenga estas propiedades
	 */
	@Test
	public void defaultConstructor() {
	Board board = new Board(Board.DEFAULT_WIDTH,Board.DEFAULT_HEIGHT,Board.DEFAULT_PERCENTAGE);
	
	assertEquals(Board.DEFAULT_WIDTH,board.getSquares().length);
	assertEquals(Board.DEFAULT_HEIGHT,board.getSquares()[0].length);
	
	int mines=Board.DEFAULT_HEIGHT*Board.DEFAULT_WIDTH*Board.DEFAULT_PERCENTAGE/100;
	assertEquals(mines,board.getNumberOfMinesLeft());
	}
}
