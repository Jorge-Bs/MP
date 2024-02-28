package uo.mp.minesweeper.console;



import uo.mp.lab.minesweeper.console.Console;
import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.GameInteractor;
import uo.mp.minesweeper.game.GameMove;

public class ConsoleGameInteractor implements GameInteractor {
	

	/**
	 * Solicita al usuario un comando y genera un gameMove
	 * @param rows, fila maxima permitida
	 * @param columns, columna maxima permitida
	 * @return un GameMove con los comandos intrododucidos por el usuario
	 */
	@Override
	public GameMove askMove(int rows, int columns) {
		char movement;
		int row;
		int column;
		print("Movements (s | f | u)? ");
		movement= (char)Console.readCharacter();
		print("Row? ");
		row = Console.readInt();
		print("Column? ");
		column = Console.readInt();
		if(!checkValues(movement,row,column,rows,columns)) {
			return askMove(rows, columns);
		}else {
			return new GameMove(movement, row, column);
		}
	}
	/**
	 * Muestra el estado del tablero y el tiempo 
	 * @param elapsedTime, para indicar el tiempo
	 * @param bd, board a representar
	 */
	@Override
	public void showGame(long elapsedTime, Board bd) {
		StringBuilder sb = new StringBuilder();
		sb.append("Time: "+elapsedTime+" seconds\n");
		sb.append(String.format("Flags left: %d\n", bd.getNumberOfFlagsLeft()));
		char[][] board = bd.getState();
		
		sb.append(numbers(board[0].length));
		sb.append(line(board[0].length));
		
		for(int i=0;i < board.length;i++) {
			sb.append(i+" "+"|"+" ");
			for(int j=0; j< board[i].length;j++) {
				sb.append(board[i][j]+" | ");
			}
			sb.append("\n");
			sb.append(line(board[0].length));
		}
		print(sb.toString());
	}
	
	/**
	 * Dibuja la informacion de las columnas
	 */
	private String numbers(int length) {
		StringBuilder sb = new StringBuilder();
		sb.append(" ");
		for (int i=0 ;i< length;i++) {
			sb.append("   "+i);
		}
		sb.append("\n");
		return sb.toString();
	}
	
	/**
	 * Dibuja la linea horizontal separadora
	 * @param length, longitud de la linea
	 * @return String con la linea del tamaño indicado
	 */
	private String line(int length) {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for (int i=0;i<length;i++) {
			sb.append("+---");
		}
		sb.append("+\n");
		return sb.toString();
	}
	/**
	 * Informa al usuario de que el juego ha terminado
	 */
	@Override
	public void showGameFinished() {
		print("The game has ended");

	}
	/**
	 * Felicita al usuario por su victoria
	 * @param elapsedTime, le muestra el tiempo transcurrido 
	 */
	@Override
	public void showCongratulations(long elapsedTime) {
		StringBuilder sb = new StringBuilder();
		sb.append("You win!!\n");
		sb.append("Time needed: "+elapsedTime+" seconds\n");
		print(sb.toString());
	}
	/**
	 * Informa al usuario de que ha pisado una casilla de mina
	 */
	@Override
	public void showBooommm() {
		print("BOOOOMMM!!!\n");
	}
	/**
	 * Informa al usuario de que el juego está listo para comenzar
	 */
	@Override
	public void showReadyToStart() {
		print("Welcome, The game is ready to start\n");
	}
	
	
	/**
	 * Imprime por pantalla el contenido del out dado como parametro
	 * @param 
	 */
	private void print(String information) {
		System.out.print(information);
	}
	
	/**
	 * Chequea los parametros
	 * @param movement
	 * @param row
	 * @param column
	 * 
	 */
	private boolean checkValues(char movement,int rowPosition, int columnPosition, int maxRow,int maxColumn) {
		boolean check=true;
		if((movement!='s'&&movement!='f'&& movement!='u')) {
			check=false;
		}
		if(rowPosition<0 || rowPosition>=maxRow) {
			check= false;
		}
		if(columnPosition<0|| columnPosition>=maxColumn) {
			check=false;
		}
		if(!check) {
			print("invalid comand, try again\n");
			return check;
		}
		return check;
	}

}
