package uo.mp.minesweeper.game.model.square;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.game.Square;

public class UnflagTest {
	private Square square;
	
	@BeforeEach
	public void setUp() {
		square = new Square();
	}
	
	/*
	 * Casos
	 * Unflag sobre casilla abierta
	 * Unflag sobre casilla cerrada
	 * Unflag sobre casilla con bandera
	 */
	
	/**
	 * Given: Una casilla abierta
	 * When: se invoca al metodo
	 * Then: la casilla tiene bandera, su estado final ser· igual al inicial, ya que no se puede
	 * 		modificar una casilla abierta
	 */
	@Test
	public void unflagOverOpenSquare(){
		square.open();
		assertTrue(square.isOpened());
		square.unflag();
		assertFalse(square.isFlagged());
		assertTrue(square.isOpened());
	}
	
	
	/**
	 * Given: Una casilla cerrada
	 * When: se invoca al metodo
	 * Then: la casilla no conten√≠a la bandera, su estado final ser· igual inicial
	 */
	@Test
	public void unflagOverClosedSquare(){
		square.unflag();
		assertFalse(square.isFlagged());
		assertFalse(square.isOpened());
	}
	
	
	/**
	 * Given: Una casilla con bandera
	 * When: se invoca al metodo
	 * Then: la casilla tiene bandera, su estado final ser· cerrado, ya que solo le quitamos la bandera
	 */
	@Test
	public void unflagOverFlaggedSquare(){
		square.flag();
		assertTrue(square.isFlagged());
		square.unflag();
		assertFalse(square.isFlagged());
		assertFalse(square.isOpened());
	}
}
