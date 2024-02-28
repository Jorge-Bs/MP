package uo.mp.minesweeper;

import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.Game;
/**
 * Clase Main
 * Se encarga de inicializar el programa 
 * con un tablero de tamano 9x9 y el 12% de minas
 * @author Jorge Blanco Sánchez
 * @version 1.0
 *
 */
public class Main {


	public static void main(String[] args) {
		new Main().configure();
	}

	private Main configure() {
		Board board = new Board(9, 9, 12 /* % */);
		new Game( board );
		return this;
	}

	

}
