package uo.mp.minesweeper.game.square.actions.blowup;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.model.util.ForTesting;
import uo.mp.minesweeper.game.square.Square;

public class ExecuteTest {

	/**
	 * Given: un tablero 4x4 con una mina
	 * When: se invoca steepOn con la accion blowUp
	 * Then: el tablero se marca como explotado
	 * 
	 */
	@Test
	public void steepInBomb() {
		Square squares[][] = ForTesting.fillBoardClose(4);
		squares[0][0].putMine();
		Board bd = new Board(0,squares);
		bd.stepOn(0, 0);
		
		assertTrue(bd.hasExploded());
	}

}
