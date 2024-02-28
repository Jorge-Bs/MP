package uo.mp.minesweeper.game;

import uo.mp.minesweeper.util.check.ArgumentChecks;

/**
 * Clase de interacion con  el usuraio
 * 
 * Minesweeper game
 * Juego en el que el usuario intentara descubrir todas las minas en un tablero
 * El juego mostra con un valor numerico la cantidad de minas que hay proximas a la casilla
 * Se finalizara la partida cuando explote una mina o descubras todas las minas que hay presente
 * Los movimientos permitidos son:
 * 
 * Flag-(f): Permite poner una bandera sobre la casilla
 * Unflag-(u): Quita la bandera de la casilla
 * Steep Over -(s): descubre la casilla
 * 
 * 
 * @author Jorge Blanco Sánchez
 * @version 1.0
 *
 */
public class Game {
	private Board board;
	private long startTime=System.currentTimeMillis();
	private GameInteractor interactor;
	
	
	/**
	 * Inicializa el juego con el board recibido
	 * @param bd de tipo Board
	 */
	public Game(Board bd) {
		setBoard(bd);
	}
	
	/**
	 * Establece el interactor que se da como parametro
	 * @param interactor
	 */
	public void setInteractor(GameInteractor interactor) {
		ArgumentChecks.isTrue(interactor!=null,"Invalid interactor");
		this.interactor=interactor;
	}
	
	
	/**
	 * Se encarga de realizar los diferentes movimientos
	 */
	public void play() {
		int row=board.getNumberOfRows();
		int column=board.getNumberOfColumns();
		board.uncoverWelcomeArea();
		interactor.showReadyToStart();
		do {
			interactor.showGame(getTime(), board);
			GameMove movement = interactor.askMove(row,column);
			switch(movement.getOperation()) {
			case 's':
				board.stepOn(movement.getRow(), movement.getColumn());
				break;
			case 'f':
				board.flag(movement.getRow(), movement.getColumn());
				break;
			case 'u':
				board.unflag(movement.getRow(), movement.getColumn());
				break;
			}
		}while(!isFinish());
		board.unveil();
		interactor.showGame(getTime(), board);
		if(board.hasExploded()) {
			interactor.showBooommm();
		}else {
			interactor.showCongratulations(getTime());
		}
		
	}
	
	/**
	 * Establece el tablero
	 * @param bd de tipo board
	 */
	private void setBoard(Board bd) {
		this.board=bd;
	}
	
	/**
	 * Obtiene el tiempo y lo imprime por pantalla
	 * @param PrintStream de tipo out
	 */
	private long getTime() {
		long seconds = (System.currentTimeMillis()-startTime)/1000;
		return seconds;
	}
	
	/**
	 * Devuelve true si el juego se ha terminado
	 * @return true si se ha terminado, false en caso contrario
	 * 
	 */
	private boolean isFinish() {
		return board.hasExploded() || board.getNumberOfMinesLeft()==0;
	}
}

