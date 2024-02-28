package uo.mp.lab02.game.model;

import java.util.Random;

import uo.mp.lab.util.check.ArgumentChecks;

/**
 * <p>
 * Título: Clase Game2048
 * </p>
 * <p>
 * Descripción: A partir de un array bidimensional de números y a través de
 * diferentes operaciones se simula un juego llamado "2048"
 * </p>
 * <p>
 * Copyright: Copyright (c) 2023
 * </p>
 * <p>
 * Empresa: Escuela de Ingeniería Informática - Uiversidad de Oviedo
 * </p>
 * 
 * @author Jorge Blanco Sánchez
 * @version 11-02-2023
 */
public class Game2048 {
	public static final int MIN = 3;
	public static final int MAX = 5;
	public static final int DEFAULT_VALUE = 0;
	public static final int DEFAULT_NUMBER = 2;
	public static final int WIN_VALUE=2048;

	private int[][] board;

	/**
	 * Constructor sin parámetros con tablero por defecto de 3*3 Inicialmente todas
	 * las posiciones con valor 0
	 */
	public Game2048() {
		setBoard(MIN);
	}

	/**
	 * Metodo privado para generar vacio un tablero
	 * 
	 * @param size ,tamaño del tablero
	 */
	private void setBoard(int size) {
		board = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = DEFAULT_VALUE;
			}
		}
	}

	/**
	 * Constructor que recibe el tamaño del tablero
	 *
	 * @param size ,tamaño del tablero cuadrado. Si el tamaño no está entre el mínimo (3)
	 *               y el máximo (5) se crea un tablero con el valor por defecto (3)
	 */
	public Game2048(int size) {
		if (size < MIN || size > MAX) {
			setBoard(MIN);
		} else {
			setBoard(size);
		}
	}

	/**
	 * Inicializa el tablero con la matriz recibida como parámetro, Util para
	 * propósito de test. Se crea UNA COPIA (se denomina copia defensiva)del
	 * parámetro en el tablero interno para evitar que desde fuera se pueda
	 * modificar los valores del tablero a posteriori
	 * 
	 * @param board, matriz cuadrada, de dimensiones entre máximo (5x5) y el mínimo (3x3)
	 *               conteniendo solo valores potencia de 2.
	 * 
	 * @throws IllegalArgumentException si parámetro null, la dimension es errónea,
	 *                                  o hay valores inadecuados (no son potencia
	 *                                  de 2).
	 */

	public Game2048(int[][] board) {
		ArgumentChecks.isTrue(isBoardAllowed(board), "Tablero inadecuado o null");
		this.board = clone(board);
	}
	
	/**
	 * Método privado para clonar el board
	 * @param board a copiar
	 * @return board copiado
	 */
	private int[][] clone(int[][] board){
		int [][]copy = new int[board.length][board.length];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++){
				copy[i][j]=board[i][j];
			}
		}
		return copy;
	}
	/**
	 * Método privado para saber si el tablero introduciodo es correcto o no
	 * 
	 * @param board de tipo int[][]
	 * @return boolean condition
	 */
	private boolean isBoardAllowed(int board[][]) {
		if (board == null || board.length < MIN || board.length > MAX) {
			return false;
		}
		for (int i = 0; i < board.length; i++) {
			if (board.length != board[i].length) {
				return false;
			} else {
				for (int j = 0; j < board[i].length; j++) {
					if (!powerOfTwoBitwise(board[i][j])) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Calcula si un numero es potencia de 2
	 * @param n entero >= 0
	 * 
	 * @return true si n is potencia de 2; false en otro caso
	 * 
	 */
	private boolean powerOfTwoBitwise(int n) {
		return (n & (n - 1)) == 0; 
	}

	/**
	 * Devuelve UNA COPIA de la matriz para poder usarla en las pruebas
	 * 
	 * @return copia exacta del tablero
	 */
	public int[][] getBoardForTesting() {
		return clone(board); 
	}

	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un 2 en una
	 * posición aleatoria
	 */
	public void restart() {
		setBoard(board.length);
		next();
	}

	/**
	 * Añade un nuevo 2 en una posición aleatoria vacía siempre que exista alguna
	 * 
	 */
	public void next() {
		if(!isBoardFull()) {
			Random ran = new Random();
			int i = ran.nextInt(board.length);
			int j = ran.nextInt(board.length);
			if (board[i][j] != DEFAULT_VALUE) {
				next();
			} else {
				board[i][j] = DEFAULT_NUMBER;
			}
		}
	}

	/**
	 * Comprueba si el tablero está lleno. Esto ocurre cuando todas las celdas o
	 * posiciones del tablero tienen un número distinto de cero
	 * 
	 * @return true si está el tablero lleno, false si hay algún hueco
	 */
	private boolean isBoardFull() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == DEFAULT_VALUE) {
					return false;
				}
			}
		}
		return true;

	}
	
	/**
	 * Método publico para compactar a la derecha y si hay dos numeros iguales y consecutvios
	 * los suma 
	 */
	public void moveRight() {
		compactRight();
		sumConsecutivesNumber();
		compactRight();
	}
	/**
	 * Compacta el tablero a la derecha, dejando en cada fila todos los valores
	 * positivos consecutivos en las últimas posiciones de la fila y todos los ceros
	 * en las primeras posiciones de la fila
	 */
	private void compactRight() {
		for(int i=0;i<board.length;i++) {
			compactRowRight(i);
		}
	}
	/**
	 * Compacta la fila hacia la derecha
	 * @param row de tipo int column a compactar
	 */
	private void compactRowRight(int row) {
		for(int j=board.length-1;j>=0;j--) {
			if(board[row][j]==DEFAULT_VALUE) {
				int value=findPositionAtLeftWithValueFor(row,j);
				if(value >= 0) {
					board[row][j]=board[row][value];
					board[row][value]=DEFAULT_VALUE;
				}
			}
		}
	}
	
	/**
	 * Busca una posicion con valor a la izquierda para intercambiar valores
	 * @param row fila que se esta compactando
	 * @param column, posicion de partida, desde se empieza a compactar
	 * @return indice, si hay elemento o -1 si no lo hya
	 */
	private int findPositionAtLeftWithValueFor(int row,int column) {
		for(int k=column-1;k>=0;k--) {
			if(board[row][k]!=DEFAULT_VALUE) {
				return k;
			}
		}
		return -1;
	}
	/**
	 * Método privado para sumar dos números iguales que sean consecutvios
	 */
	private void sumConsecutivesNumber() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length-1;j++) {
				if(board[i][j]==board[i][j+1]) {
					board[i][j]=board[i][j]*2;
					board[i][j+1]=DEFAULT_VALUE;
				}
			}
		}
	}
	/**
	 * Método publico que permite mover los elementos a izquierda y sumar los que sean
	 * consecutivos, siempre que sean iguales.
	 */
	public void moveLeft() {
		rotateBoard(2);
		moveRight();
		rotateBoard(2);
	}
	
	/**
	 * Método publico que permite mover los elementos a la parte superior y sumar los que sean
	 * consecutivos, siempre que sean iguales.
	 */
	public void moveUp() {
		rotateBoard(3);
		moveRight();
		rotateBoard(1);
	}
	
	/**
	 * Método publico que permite mover los elementos a la parte superior y sumar los que sean
	 * consecutivos, siempre que sean iguales.
	 */
	public void moveDown() {
		rotateBoard(1);
		moveRight();
		rotateBoard(3);
	}
	
	/**
	 * Metodo toString que dibuja el estado del tablero
	 * @return un String con los datos de la matriz en formato para ser mostrado por
	 *         pantalla Habrá 5 espacios para cada posición en la misma fila y un \n
	 *         al final de cada fila Ejemplo. Para luego escribir: 2 2 0 2 0 0 2 0 2
	 *         Se devuelve el String "2 2 0\n2 0 0\n2 0 2\n"
	 */
	public String toString() {
//		String properties="";
//		for(int i=0;i<board.length;i++) {
//			for(int j=0;j<board.length;j++) {
//				properties = properties+ board[i][j];
//				properties = (j!=board.length-1)? (properties +" "):(properties + "\n");
//			}
//		}
		StringBuilder sb= new StringBuilder();
		for(int row=0;row < this.board.length;row++) {
			for(int col=0;col<this.board.length;col++) {
				sb.append(String.format("%-5s", board[row][col]));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	/**
	 * Método privado para guirar el tablero tantas veces como indique el parámetro
	 * @param rotations de tipo int,cantidad de giros al tablero en sentido antihorario
	 */
	private void rotateBoard(int rotations) {
		for(int i=0;i<rotations;i++) {
			inversa();
			transpuesta();
			
		}
		
	}
	/**
	 * Método privado para calcular la transpuesta de la matriz
	 * 
	 */
	private void transpuesta() {
		for(int j=0;j<(board.length/2)+1;j++) {
			for(int k=j;k<board.length;k++) {
				int save=board[j][k];
				board[j][k]=board[k][j];
				board[k][j]=save;
			}
		}
	}
	/**
	 * Método privado para intecambiar los valores,
	 * es decir, el valor en 00 estaría en 03, en un caso de una matrix 3x3
	 */
	private void inversa() {
		for(int j=0;j<board.length;j++) {
			for(int k=0;k<(board.length/2);k++) {
				int save=board[j][k];
				board[j][k]=board[j][board.length-1-k];
				board[j][board.length-1-k]=save;
				
			}
		}
	}

	/**
	 * Indica si el jugador ha terminado o no
	 * @return false si el jugador no ha ganado todavía y hay algunos huecos en el
	 *         tablero; true en otro caso
	 */
	public boolean isFinished() {

		return (isTheFinalValueIn()||isBoardFull());
	}
	
	/**
	 * Metodo que busca si se ha alcanzado la maxima puntuacion.
	 * @return boolean condition, true si se ha alcanzado, false en caso contrario
	 */
	private boolean isTheFinalValueIn() {
		for (int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j]==WIN_VALUE) {
					return true;
				}
			}
		}
		return false;
	}
}
