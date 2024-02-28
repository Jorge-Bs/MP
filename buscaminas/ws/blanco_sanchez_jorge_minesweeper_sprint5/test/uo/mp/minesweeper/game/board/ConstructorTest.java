package uo.mp.minesweeper.game.board;

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
	Board board = new Board(9,9,12);
	
	assertEquals(9,board.getSquares().length);
	assertEquals(9,board.getSquares()[0].length);
	
	assertEquals(10,board.getNumberOfMinesLeft());
	}
	
	/**
	 * Given: nothing 
	 * When: se instancia la clase con un tablero no cuadrado
	 * Then: se comprueba que tiene las dimensiones y las minas que le corresponden
	 */
	@Test
	public void nonSquareBoardConstructor() {
	Board board = new Board(10,9,12);
	
	assertEquals(9,board.getSquares().length);
	assertEquals(10,board.getSquares()[0].length);
	
	assertEquals(11,board.getNumberOfMinesLeft());
	}
}
