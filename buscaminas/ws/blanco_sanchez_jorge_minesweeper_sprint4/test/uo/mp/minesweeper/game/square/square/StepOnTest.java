package uo.mp.minesweeper.game.square.square;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.exception.GameException;
import uo.mp.minesweeper.game.square.Square;

public class StepOnTest {
	private Square square;
	/*
	 * casos
	 * 
	 * Sobre casilla abierta
	 * Sobre casilla cerrada 
	 * Sobre casilla con banderaa
	 */
	
	@BeforeEach
	public void setUp() {
		square = new Square();
	}
	
	
	
	/**
	 * Given: Una casilla con el estado abierta
	 * When: se invoca al metodo
	 * Then: la casilla no se modifica
	 */
	@Test
	public void stepOnOverOpenSquare() {
		square.open();
		assertTrue(square.isOpened());//se comprueba que el estado es abierto ya que se inicializa cerrada,
										//y se necesita que este abierta en este caso
		try {
			square.stepOn();
		} catch (GameException e) {
			assertTrue(true);
		}
		assertTrue(square.isOpened());
	}
	
	/**
	 * Given: una casilla con el estado cerrada
	 * When: se invoca al metodo
	 * Then: la casilla pasa a estar abierta
	 * @throws GameException 
	 */
	@Test
	public void stepOnOverClosedSquare() throws GameException {
		square.stepOn();
		assertTrue(square.isOpened());
	}
	
	/**
	 * Given: una casilla con el estado flagged
	 * When: se invoca al metodo
	 * Then: la casilla pasa a estar abierta
	 * @throws GameException 
	 */
	@Test
	public void stepOnOverFlaggedSquare() throws GameException {
		square.flag();
		try {
			square.stepOn();
		} catch (GameException e) {
			assertTrue(true);
		}
		assertFalse(square.isOpened());
	}
}
