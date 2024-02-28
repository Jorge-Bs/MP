package uo.mp.minesweeper.game;


import uo.mp.minesweeper.exception.GameException;
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
	private static final boolean DERROTA = false;
	private static final boolean VICTORIA = !DERROTA;
	private Board board;
	private long startTime=System.currentTimeMillis();
	private GameInteractor interactor;
	private boolean resultado;
	
	
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
	public Game play() {
		
		welcome();
		interactor.showReadyToStart();
		
		askMove();
		
		board.unveil();
		interactor.showGame(getTime(), board);
		register();
		return this;
	}

	private void welcome() {
		try {
			board.uncoverWelcomeArea();
		}catch(GameException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Establece la victoria o derrota del tablero y muestra su mensaje
	 */
	private void register() {
		if(board.hasExploded()) {
			interactor.showBooommm();
			setResultado(DERROTA);
		}else {
			interactor.showCongratulations(getTime());
			setResultado(VICTORIA);
		}
	}

	/**
	 * Pregunta en bucle el movimiento que el jugador desea realizar
	 */
	private void askMove(){
		int row=board.getNumberOfRows();
		int column=board.getNumberOfColumns();
		do {
			try {
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
			}catch (GameException e) {
				System.out.println(e.getMessage());
			}
		}while(!isFinish());
	}
	
	/**
	 * Devuelve el tiempo de duracion de la partida
	 * @return time
	 */
	public long getDuration() {
		return getTime();
	}
	
	public boolean hasWon() {
		return resultado;
	}

	private void setResultado(boolean resultado) {
		this.resultado = resultado;
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

