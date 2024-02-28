package uo.mp.minesweeper.game.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.exception.GameException;
import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.model.util.ForTesting;
import uo.mp.minesweeper.game.square.Square;

public class UncoverWelcomeAreaTest {
	private Board bd;
	private Square sq3[][];
	private Square sq5[][];
	

	@BeforeEach
	public void setUp() {
		sq3= ForTesting.fillBoardClose(3);
		sq5= ForTesting.fillBoardClose(5);
		
	}
	
	/**
	 * Given: una tablero 3x3
	 * When: se inicializa el juego y se llama a la funcion uncoverWelcomeArea
	 * Then: se descubre un area inicial
	 * @throws GameException 
	 * 
	 */
	@Test
	public void threeSquareBoardWithOneMine() throws GameException {
		sq3[0][0].putMine();
		bd = new Board(1,sq3);
		bd.uncoverWelcomeArea();
		for(int i=0;i<sq3.length;i++) {
			for(int j=0; j<sq3[i].length;j++) {
				if(i==0 && j==0) {
					continue;
				}
				else if(!(sq3[i][j].isOpened())){
					assertTrue(false);
				}
			}
		}
		assertTrue(true);
	}
	
	/**
	 * Given: una tablero 5x5
	 * When: se inicializa el juego y se llama a la funcion uncoverWelcomeArea
	 * Then: se descubre un area inicial
	 * @throws GameException 
	 * 
	 */
	@Test
	public void boardWithMines() throws GameException {
		sq5[0][0].putMine();
		sq5[0][4].putMine();
		sq5[1][4].putMine();
		sq5[2][4].putMine();
		bd = new Board(4,sq5);
		bd.uncoverWelcomeArea();
		print(sq5);
	}
	
	
	/**
	 * Given: una tablero 3x6
	 * When: se inicializa el juego y se llama a la funcion uncoverWelcomeArea
	 * Then: se descubre un area inicial
	 * @throws GameException 
	 * 
	 */
	@Test
	public void boardNonSquare() throws GameException {
		Square sq[][]= {{new Square(),new Square(),new Square(),new Square(),new Square(),new Square()},
						{new Square(),new Square(),new Square(),new Square(),new Square(),new Square()},
						{new Square(),new Square(),new Square(),new Square(),new Square(),new Square()}};
		sq[0][0].putMine();
		sq[0][4].putMine();
		sq[1][4].putMine();
		sq[2][4].putMine();
		bd = new Board(4,sq);
		bd.uncoverWelcomeArea();
		print(sq);
	}
	
	private void print(Square[][] sq) {
		for(int i=0;i<sq.length;i++) {
			for(int j=0; j<sq[i].length;j++) {
				System.out.print(sq[i][j].toString()+" ");
			}
			System.out.print("\n");
		}
		System.out.println("------------");
		
		
	}

	

}
