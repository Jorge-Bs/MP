package uo.mp.minesweeper.console;


import uo.mp.lab.minesweeper.console.Console;
import uo.mp.minesweeper.exception.GameException;
import uo.mp.minesweeper.exception.UserInteractionException;
import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.GameInteractor;
import uo.mp.minesweeper.game.GameMove;

public class ConsoleGameInteractor implements GameInteractor {
	
	private int rows;
	private int columns;

	/**
	 * Solicita al usuario un comando y genera un gameMove
	 * @param rows, fila maxima permitida
	 * @param columns, columna maxima permitida
	 * @return un GameMove con los comandos intrododucidos por el usuario
	 * @throws GameException 
	 * @throws UserInteractionException 
	 */
	@Override
	public GameMove askMove(int rows, int columns) throws  GameException {
		try {
			setValues(rows,columns);
			print("Movements (s | f | u)? ");
			char movement= (char)Console.readCharacter();
			print("Row? ");
			int row = Console.readInt();
			print("Column? ");
			int column = Console.readInt();
			return toGameMove(movement,row,column);
		}catch(NullPointerException e) {
			throw new GameException("Operacion introducida no valida, vuelva a intentarlo");
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
			if(i<10) {
				sb.append(i+"  "+"|"+" ");
			}else {
				sb.append(i+" "+"|"+" ");
			}
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
		sb.append("  ");
		for (int i=0 ;i< length;i++) {
			if(i<10) {
				sb.append("   "+i);
			}else {
				sb.append("  "+i);
			}
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
		sb.append("   ");
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
	 * @throws UserInteractionException 
	 * @throws GameException 
	 * 
	 */
	private void checkValues(char movement,int rowPosition, int columnPosition) 
			throws GameException {
		if((movement!='s'&&movement!='f'&& movement!='u')) {
			throw new GameException("Valor operacion invalida");
		}
		if(rowPosition<0 || rowPosition>=getRows()) {
			throw new GameException("Fila invalida");
		}
		if(columnPosition<0|| columnPosition>=getColumns()) {
			throw new GameException("Columna invalida");
		}
	}
	
	/**
	 * Devuelve el numero máximo de filas
	 * @return rows
	 */
	private int getRows() {
		return rows;
	}
	
	/**
	 * Establece el numero maximo de filas
	 * @param rows
	 */
	private void setRows(int rows) {
		this.rows = rows;
	}
	
	/**
	 * Devuelve el numero máximo de columnas
	 * @return rows
	 */
	private int getColumns() {
		return columns;
	}
	
	/**
	 * Establece el numero maximo de columnas
	 * @param columns
	 */
	private void setColumns(int columns) {
		this.columns = columns;
	}
	
	/**
	 * Establece los valores maximos de columnas y filas
	 * @param row
	 * @param column
	 */
	private void setValues(int row,int column) {
		setRows(row);
		setColumns(column);
	}
	
	
	private GameMove toGameMove(char move,int row,int column) throws GameException {
		checkValues(move, row, column);
		return new GameMove(move, row, column);
	}
	
	
	

}
