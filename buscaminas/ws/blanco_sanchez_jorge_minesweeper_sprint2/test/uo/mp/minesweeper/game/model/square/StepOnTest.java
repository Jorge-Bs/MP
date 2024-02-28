package uo.mp.minesweeper.game.model.square;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.game.Square;

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
		square.stepOn();
		assertTrue(square.isOpened());
	}
	
	/**
	 * Given: una casilla con el estado cerrada
	 * When: se invoca al metodo
	 * Then: la casilla pasa a estar abierta
	 */
	@Test
	public void stepOnOverClosedSquare() {
		square.stepOn();
		assertTrue(square.isOpened());
	}
	
	/**
	 * Given: una casilla con el estado flagged
	 * When: se invoca al metodo
	 * Then: la casilla pasa a estar abierta
	 */
	@Test
	public void stepOnOverFlaggedSquare() {
		square.flag();
		square.stepOn();
		assertFalse(square.isOpened());
	}
}
