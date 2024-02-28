package uo.mp.minesweeper.game.square.actions.clear;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;


import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.model.util.ForTesting;
import uo.mp.minesweeper.game.square.Square;

public class ExecuteTest {


	/**
	 * Given: un tablero 4x4 sin minas,
	 * When: se usa execute() hacer steepOn sobre una casilla
	 * Then: el tablero esta en blanco
	 */
	@Test
	public void allBoardWithoutMines() {
		Square squares[][] = ForTesting.fillBoardClose(4);
		Board bd = new Board(0,squares);
		bd.stepOn(0, 0);
		status(System.out,bd);
		
		assertTrue(isAllOpened(bd));
	}
	
	/**
	 * Given: un tablero con una mina
	 * When: se hace steepOn() sobre una casilla vacia
	 * Then: se muestra por pantalla todo el tablero vacio menos la casilla donde está la mina  
	 */
	@Test
	public void boardWithMine() {
		Square squares[][] = ForTesting.fillBoardClose(4);
		squares[0][0].putMine();
		Board bd = new Board(0,squares);
		bd.stepOn(3, 0);
		status(System.out,bd);
	}
	
	/**
	 * Given: un tablero con mina
	 * When: se utiliza steepOn sobre  una casilla con valor numerico
	 * Then: solo se descubre esa casilla, el resto del tablero queda es su estado anterior
	 */
	@Test
	public void steepOverNumericSquare() {
		Square squares[][] = ForTesting.fillBoardClose(4);
		squares[0][0].putMine();
		Board bd = new Board(1,squares);
		bd.stepOn(1, 0);
		status(System.out,bd);
	}
	
	/**
	 * Given: un tablero 3x3, con una mina en 0 0
	 * When: se hace esteepOn sobre la casilla vacia 1 2
	 * Then: se descubre todo el tablero menos la casilla 0 0
	 */
	@Test
	public void steepOnOverThreeSquareBoard() {
		Square squares[][]= ForTesting.fillBoardClose(3);
		squares[0][0].putMine();
		Board bd = new Board(1,squares);
		bd.stepOn(1,2);
		status(System.out,bd);
		
	}
	
	/**
	 * Comprueba que el tablero está descubierto, se utilaza en el caso donde no hay mina
	 * @param bd
	 * @return boolean true si está vacio, false en caso contrario
	 */
	private boolean isAllOpened(Board bd) {
		Square sq[][] = bd.getSquares();
		for(int i=0;i<sq.length;i++) {
			for(int j=0;j<sq[i].length;j++) {
				if(!sq[i][j].isOpened()) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	 * Imprime el estado del tablero
	 * 
	 * @param out
	 */
	private void status(PrintStream out,Board bd) {
		char[][] board = bd.getState();
		for(int i=0;i < board.length;i++) {
			for(int j=0; j< board[i].length;j++) {
				out.print(board[i][j]+" ");
			}
			out.println();
		}
		out.println("----------");
	}
}
