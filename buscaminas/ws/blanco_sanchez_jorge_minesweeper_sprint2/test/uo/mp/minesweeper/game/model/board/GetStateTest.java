package uo.mp.minesweeper.game.model.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.Square;
import uo.mp.minesweeper.game.model.util.ForTesting;

public class GetStateTest {
	private Square[][] sq;
	private Board bd;
	
	@BeforeEach
	public void setUp() {
		sq= ForTesting.fillBoardClose();
	}
	
	/**
	 * Given: un tablero totalmente cubierto
	 * When: se invoca al metodo
	 * Then: El array debe de contener # 
	 */
	@Test
	public void getStateTestCovered() {
		char[][] expected= {{'#','#','#','#'},{'#','#','#','#'},{'#','#','#','#'},{'#','#','#','#'}};
		bd = new Board(0, sq);
		assertArrayEquals(expected,bd.getState());
	}
	
	/**
	 * Given: un tablero descubierto
	 * When: se invoca al metodo 
	 * Then: el array contendrá el caracter " "
	 * 
	 */
	@Test
	public void getStateTestUncovered() {
		char[][] expected= {{' ',' ',' ',' '},{' ',' ',' ',' '},{' ',' ',' ',' '},{' ',' ',' ',' '}};
		bd = new Board(0, sq);
		bd.unveil();
		assertArrayEquals(expected,bd.getState());
	}
	
	/**
	 * Given: un tablero en estado intermedio
	 * When: se invoca al metodo
	 * Then: el array tiene los caracteres segun el estado de la casilla
	 */
	@Test
	public void getStateMid() {
		bd = new Board(0, sq);
		sq[0][0].putMine();
		sq[0][0].flag();
		
		sq[0][1].flag();
		
		sq[0][2].open();
		
		sq[0][3].setValue(2);
		sq[0][3].open();
		
		sq[1][0].setValue(4);
		
		char flag = Character.toString((char) 182).charAt(0);
		
		char[][] expected= {{flag,flag,' ','2'},{'#','#','#','#'},{'#','#','#','#'},{'#','#','#','#'}};
		assertArrayEquals(expected,bd.getState());
	}

}
