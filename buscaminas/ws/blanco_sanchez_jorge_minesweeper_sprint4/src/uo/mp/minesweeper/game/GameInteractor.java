package uo.mp.minesweeper.game;

import uo.mp.minesweeper.exception.GameException;

public interface GameInteractor {

	/**
	 * Solicita al usuario un comando y genera un gameMove
	 * @param rows, fila maxima permitida
	 * @param columns, columna maxima permitida
	 * @return un GameMove con los comandos intrododucidos por el usuario
	 */
	GameMove askMove(int rows,int columns) throws GameException ;
	
	/**
	 * Muestra el estado del tablero y el tiempo 
	 * @param elapsedTime, para indicar el tiempo
	 * @param bd, board a representar
	 */
	void showGame(long elapsedTime, Board bd);
	
	/**
	 * Informa al usuario de que el juego ha terminado
	 */
	void showGameFinished();
	
	/**
	 * Felicita al usuario por su victoria
	 * @param elapsedTime, le muestra el tiempo transcurrido 
	 */
	void showCongratulations(long elapsedTime);
	
	/**
	 * Informa al usuario de que ha pisado una casilla de mina
	 */
	void showBooommm();
	
	/**
	 * Informa al usuario de que el juego está listo para comenzar
	 */
	void showReadyToStart();
	
}
