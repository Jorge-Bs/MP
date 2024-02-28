package uo.mp.minesweeper.game.ui;



import java.io.PrintStream;

import uo.mp.lab.minesweeper.console.Console;
import uo.mp.minesweeper.game.model.Board;
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
	
	
	/**
	 * Inicializa el juego con el board recibido
	 * @param bd de tipo Board
	 */
	public Game(Board bd) {
		setBoard(bd);
		game();
		
	}
	
	/**
	 * Metodo que llama a los controles basicos del juego,
	 * funcionara en bucle siempre que el usuario quiera seguir jugando
	 */
	private void game() {
		play();
		if(userWantsAnotherPlay(System.out)) {
			new Game(new Board(9,9,12));
		}
	}
	
	/**
	 * Se encarga de realizar los diferentes movimientos
	 */
	private void play() {
		
		showTitle(System.out);
		int x;
		int y;
		
		do {
			getTime(System.out);
			flag(System.out);
			status(System.out,board);
			showCommands(System.out);
			switch(Console.readCharacter()) {
			case 'f':
			case 'F':
				x=Console.readInt();
				y=Console.readInt();
				board.flag(x, y);
				break;
			case 'u':
			case 'U':
				x=Console.readInt();
				y=Console.readInt();
				board.unflag(x, y);
				break;
			case 's':
			case 'S':
				x=Console.readInt();
				y=Console.readInt();
				board.stepOn(x, y);
				break;
			}
		}while(!board.hasExploded()&&(board.getNumberOfMinesLeft()>0));
		end();
	}
	
	/**
	 * Establece el tablero
	 * @param bd de tipo board
	 */
	private void setBoard(Board bd) {
		this.board=bd;
	}
	
	/**
	 * Metodo privado para que el usuario decida si quiere continuar jugando
	 * cuando se alcanza el estado final 
	 * 
	 * @return true si quiere seguir jugando, false en caso contrario
	 * 
	 */
	private boolean userWantsAnotherPlay(PrintStream out) {
		out.println("Do you want to play again? (s|n)");
		int value = Console.readCharacter();
		if(value==('s')||value==('S')) {
			return true;
		}
		return false;
	}
	
	/**
	 * Muestra el titulo del juego
	 * @param out de tipo printStream 
	 */
	private void showTitle(PrintStream out) {
		out.println("Welcome: " +"\n"+"Ready to start");
	}
	
	/**
	 * Muestra los comandos
	 * @param out de tipo printStream
	 */
	private void showCommands(PrintStream out) {
		out.println("Movements (s | f | u)");
	}
	
	/**
	 * Imprime el estado del tablero
	 * 
	 * @param out
	 */
	private void status(PrintStream out,Board bd) {
		char[][] board = bd.getState();
		for(int i=0;i < board.length;i++) {
			for(int j=0; j< board[i].length;j++) {
				out.print(board[i][j]+" ");
			}
			out.println();
		}
	}
	
	/**
	 * Imprime las banderas restantes
	 * @param out de tipo PrintStream
	 */
	private void flag(PrintStream out) {
		out.println("Flags left: "+board.getNumberOfFlagsLeft());
	}
	
	/**
	 * Muestra el mensaje del final y el tablero decubierto
	 */
	private void end() {
		if(board.hasExploded()) {
			showExplosion(System.out);
		}else {
			win(System.out);
		}
		board.unveil();
		status(System.out, board);
	}
	
	/**
	 * Muestra el mensaje final si ha explotado una bomba
	 * @param out de tipo PrintStream
	 */
	private void showExplosion(PrintStream out) {
		out.println("BOOOOMMM!!!");
	}
	
	/**
	 * Muestra el mensaje si ha ganado
	 * @param out de tipo PrintStream
	 */
	private void win(PrintStream out) {
		out.println("You win!!");
	}
	
	/**
	 * Obtiene el tiempo y lo imprime por pantalla
	 * @param PrintStream de tipo out
	 */
	private void getTime(PrintStream out) {
		long seconds = (System.currentTimeMillis()-startTime)/1000;
		int minutes=0;
		if(seconds>=60) {
			seconds-=60;
			minutes++;
		}
		out.println(String.format("Time: %d:%d", minutes,seconds));
	}
	
}

