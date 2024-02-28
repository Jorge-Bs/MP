package uo.mp.lab02.game.model.game2048;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uo.mp.lab02.game.model.Game2048;
import uo.mp.lab02.game.model.util.ForTesting;
/**
 * Clase de prueba para el metodo moveUp()
 * @author Jorge Blanco Sánchez
 * @version 11-02-2023
 *
 */
public class MoveUpTest {
	private Game2048 game;
	/*
	 * Casos
	 * 1-Un valor por columna en 0
	 * 2-Un valor por columna en 1
	 * 3-Un valor por columna en 2
	 * 
	 * 4-Dos valores por columna en 0 y 1
	 * 5-Dos valores por columna en 0 y 2
	 * 6-Dos valores por columna en 1 y 2
	 * 
	 * 7-Matriz llena
	 * 8-Matriz vacia
	 * 
	 * 9-Matriz 4x4 con doble compactamiento
	 */
	
	/**
	 * Given: Una matriz 3x3 con un valor por columna en la posicion 0
	 * When: Se invoca al método
	 * Then: La matriz solo se compacta hacia arriba, al no haber elementos iguales
	 */
	@Test
	public void oneValuePerColumnInCero() {
		game = new Game2048(ForTesting.SEMIFULL33);
		game.moveUp();
		assertArrayEquals(ForTesting.SEMIFULL3_UPCOMPACTED, game.getBoardForTesting());
	}
	
	
	/**
	 * Give: una matriz 3x3 con un valor por columna en posicion 1
	 * When: Se invoca al método
	 * Then: La matriz solo se compacta hacia arriba, al no haber elementos iguales
	 */
	@Test
	public void oneValuePerColumnInOne() {
		game = new Game2048(ForTesting.SEMIFULL32);
		game.moveUp();
		assertArrayEquals(ForTesting.SEMIFULL3_UPCOMPACTED, game.getBoardForTesting());
	}
	
	/**
	 * Give: una matriz 3x3 con un valor por columna en posicion 2
	 * When: Se invoca al método
	 * Then: La matriz solo se compacta hacia arriba, al no haber elementos iguales
	 */
	@Test
	public void oneValuePerColumnInTwo() {
		game = new Game2048(ForTesting.SEMIFULL31);
		game.moveUp();
		assertArrayEquals(ForTesting.SEMIFULL3_UPCOMPACTED, game.getBoardForTesting());
	}
	
	/**
	 * Given: Una matriz 3x3 con dos valores por columna en 0 y 1
	 * When: Se invoca al metodo
	 * then: La matriz se compactara hacia arriba tendrá la suma, al no ser igules no se sumaran,solo estara
	 * 		compactada hacia abrriba
	 */
	@Test
	public void twoValuesPerColumnInCeroAndOne() {
		game = new Game2048(ForTesting.SEMIFULL43);
		game.moveUp();
		assertArrayEquals(ForTesting.SEMIFULL4_UPCOMPACTED, game.getBoardForTesting());
	}
	
	/**
	 * Given: Una matriz 3x3 con dos valores por columna en 0 y 2
	 * When: Se invoca al metodo
	 * then: La matriz se compactara hacia arriba tendrá la suma, al no ser igules no se sumaran,solo estara
	 * 		compactada hacia arriba
	 */
	@Test
	public void twoValuesPerColumnInCeroAndTwo() {
		game = new Game2048(ForTesting.SEMIFULL42);
		game.moveUp();
		assertArrayEquals(ForTesting.SEMIFULL4_UPCOMPACTED, game.getBoardForTesting());
	}
	
	/**
	 * Given: Una matriz 3x3 con dos valores por columna en 0 y 1
	 * When: Se invoca al metodo
	 * then: La matriz se compactara hacia arriba tendrá la suma, al no ser igules no se sumaran,solo estara
	 * 		compactada hacia arriba
	 */
	@Test
	public void twoValuesPerColumnInOneAndTwo() {
		game = new Game2048(ForTesting.SEMIFULL41);
		game.moveUp();
		assertArrayEquals(ForTesting.SEMIFULL4_UPCOMPACTED, game.getBoardForTesting());
	}
	
	/**
	 * Given: Una matriz 3x3 llena
	 * When: Se invoca al método
	 * Then:La matriz se compactará hacia arriba, al no haber elementos que se puedan sumar,
	 * 		 se queda en el estado inicial
	 */
	@Test
	public void fullMatrix() {
		game = new Game2048(ForTesting.FULL);
		game.moveUp();
		assertArrayEquals(ForTesting.FULL, game.getBoardForTesting());
	}
	
	
	/**
	 * Given: Una matriz 3x3 vacia
	 * When: Se invoca al método
	 * Then: Al estar vacia no se realiza ninguna operacion
	 */
	@Test
	public void emptyMatrix() {
		game = new Game2048(ForTesting.EMPTY);
		game.moveUp();
		assertArrayEquals(ForTesting.EMPTY, game.getBoardForTesting());
	}
	
	
	/**
	 * Given: Una matriz 4x4
	 * When: Se invoca al método 
	 * Then: Se compacta, se suma los elementos y se vuelve a compactar
	 */
	@Test
	public void fourSquareMatrix() {
		int[][] initial= {{0,2,2,2},{2,0,2,2},{2,2,0,2},{2,2,2,0}};
		int[][] expected = {{2,2,2,2},{4,4,4,4},{0,0,0,0},{0,0,0,0}};
		game= new Game2048(initial);
		game.moveUp();
		assertArrayEquals(expected, game.getBoardForTesting());
	}
}
