package uo.mp.minesweeper.game.model.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.game.model.Board;
import uo.mp.minesweeper.game.model.Square;
import uo.mp.minesweeper.game.model.util.ForTesting;

public class FlagTest {

	Board bd;
	Square[][] sq;
	
	@BeforeEach
	public void setUp() {
		sq = ForTesting.fillBoardClose();
	}
	
	/**
	 * Given: Una casilla con bandera en un tablero
	 * When: se invoca al metodo sobre la casilla con bandera
	 * Then: No se modifica el contador
	 */
	@Test
	public void flagAFlaggedSquare() {
		bd = new Board(0, sq);
		sq[0][0].flag();
		
		assertEquals(0,bd.getNumberOfMinesLeft());
		assertEquals(0,bd.getNumberOfFlagsLeft());
		
		bd.flag(0, 0);
		assertEquals(0,bd.getNumberOfMinesLeft());
		assertEquals(0,bd.getNumberOfFlagsLeft());
		
		assertTrue(sq[0][0].isFlagged());
	}
	
	/**
	 * Given: Una casilla sin marcar y con mina en un tablero
	 * When: se invoca al metodo sobre esta casilla
	 * Then: se marca la casilla, se tiene que reducir las banderas restantes y el marcador interno de 
	 * 		de minas restantes
	 */
	@Test
	public void flagMinedSquare() {
		bd = new Board(1, sq);
		sq[0][0].putMine();
		
		assertEquals(1,bd.getNumberOfMinesLeft());
		assertEquals(1,bd.getNumberOfFlagsLeft());
		
		bd.flag(0, 0);
		
		assertEquals(0,bd.getNumberOfMinesLeft());
		assertEquals(0,bd.getNumberOfFlagsLeft());
		
	}
	
	/**
	 * Given: una casilla sin mina  y sin marcar en un tablero
	 * When: se invoca al metodo sobre esta casilla
	 * Then: se reduce en uno el marcador de las banderas, pero no el de las minas
	 */
	@Test
	public void flagNotMinedSquare() {
		bd= new Board(2, sq);
		sq[0][1].putMine();
		sq[0][0].putMine();
		
		assertEquals(2,bd.getNumberOfMinesLeft());
		assertEquals(2,bd.getNumberOfFlagsLeft());
		
		bd.flag(0, 0);
		
		assertEquals(1,bd.getNumberOfMinesLeft());
		assertEquals(1,bd.getNumberOfFlagsLeft());
		
	}
	
	/**
	 * Given: una casilla con mina en un tablero
	 * When: se invoca al metodo dos veces
	 * Then: solo se marca con la primera vez y baja el contador de banderas y de minas  en uno 
	 */
	@Test
	public void flagMinedSquareTwice() {
		bd = new Board(2, sq);
		sq[0][0].putMine();
		sq[0][1].putMine();
		
		assertEquals(2,bd.getNumberOfMinesLeft());
		assertEquals(2,bd.getNumberOfFlagsLeft());
		
		bd.flag(0, 0);
		
		assertEquals(1,bd.getNumberOfMinesLeft());
		assertEquals(1,bd.getNumberOfFlagsLeft());
		
		bd.flag(0, 0);
		
		assertEquals(1,bd.getNumberOfMinesLeft());
		assertEquals(1,bd.getNumberOfFlagsLeft());
		
	}
}
