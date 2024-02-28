package uo.mp.minesweeper.game.model;


import java.util.Random;
/**
 * Clase board
 * Contiene las funciones del programa y las casillas
 * 
 * @author Jorge Blanco Sánchez
 *
 */
public class Board {
	public static final int DEFAULT_PERCENTAGE = 12;
	public static final int DEFAULT_WIDTH = 9;
	public static final int DEFAULT_HEIGHT = 9;
	public static final boolean EXPLODED = true;
	public static final boolean NOT_EXPLODED = !EXPLODED;

	private Square board[][];
	private boolean explosion = NOT_EXPLODED;
	private int mines;
	private int flags;
	private int minesLeft;

	/**
	 * Constructor que crea un tablero de tamaño width*height, y añade la cantidad
	 * correspondiente de mina, tamaño Total*porcentaje
	 * 
	 * @param  width de tipo int, anchura, columnas
	 * @param  height de tipo int, altura, filas
	 * @param  percentaje de tipo int, porcentaje de minas
	 * 
	 */
	public Board(int width, int height, int percentaje) {
		setBoard(width, height);
		fillBoard();
		setMines(calculateMines(width, height, percentaje));
		putMines(getMines());
		setNumber();
		setFlag(getMines());

	}

	/**
	 * Costructor que dado una matriz de casillas, coloca las minas dadas y asigan
	 * el valor numerico a cada casilla
	 * 
	 * @param mines,   minas a colocar
	 * @param squares, tablero que se utiliza
	 */
	public Board(int mines, Square[][] squares) {
		board = squares;
		setMines(mines);
		setNumber();
		setFlag(mines);
	}

	/**
	 * Inicializa el tamaño del tablero
	 * 
	 * @param width,  anchura, es decir, numero de columnas
	 * @param height, longitud, numero de filas
	 */
	private void setBoard(int width, int height) {
		board = new Square[height][width];
	}

	/**
	 * Devuelve una copia del tablero
	 * 
	 * @return copy del tablero
	 */
	private Square[][] getBoard() {
		Square[][] copy = new Square[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				copy[i][j] = board[i][j].clone();
			}
		}
		return copy;
	}

	/**
	 * Metodo privado que establece el valor del atributo flag
	 * @param flags de tipo int, banderas que se pueden colocar
	 */
	private void setFlag(int flags) {
		this.flags = flags;
	}

	/**
	 * Metodo que devuelve la cantidad restante de banderas por poner
	 * 
	 * @return flags, cantidad de banderas restantes
	 */
	private int getFlag() {
		return flags;
	}

	/**
	 * Calcula cuantas minas hay que establecer
	 * 
	 * @param width,      anchura
	 * @param height,     longitud
	 * @param percentaje, porcentaje el valor debe de ser Entero
	 * @return mines el numero de minas que hay
	 */
	private int calculateMines(int width, int height, int percentaje) {
		return width * height * percentaje / 100;
	}

	/**
	 * Metodo que llena el tablero con casillas sin minas
	 */
	private void fillBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new Square();
			}
		}
	}

	/**
	 * Metodo que establece el valor de la minas
	 * 
	 * @param mines
	 */
	private void setMines(int mines) {
		this.mines = mines;
		setMinesLeft(mines);
	}

	/**
	 * Establece el valor de la minas restantes
	 * 
	 * @param int minesLeft
	 * 
	 */
	private void setMinesLeft(int minesLeft) {
		this.minesLeft = minesLeft;
	}

	/**
	 * Metodo que establece en casillas aleatorias las minas
	 * 
	 * @param mines
	 */
	private void putMines(int mines) {
		int minesLeft = mines;
		int rows = board.length;
		int column = board[0].length;

		while (minesLeft != 0) {
			Random rd = new Random();
			int i = rd.nextInt(rows);
			int j = rd.nextInt(column);

			if (canPutMine(i, j)) {
				board[i][j].putMine();
				minesLeft--;
			}
		}
	}

	/**
	 * Metodo que devuelve las minas restantes
	 * 
	 * @return minesLeft
	 */
	private int getMinesLeft() {
		return minesLeft;
	}

	/**
	 * Metodo que devuelve la cantidad de minas
	 * 
	 * @return mines
	 */
	private int getMines() {
		return mines;
	}

	/**
	 * Metodo que analiza la casilla y nos devuelve true si esta no contiene mina
	 * 
	 * @param row,   fila de tipo int
	 * @param column ,columna de tipo int
	 * @return boolean true si podemos poner mina, false en caso contrario
	 */
	private boolean canPutMine(int row, int column) {
		return (board[row][column].getValue() != Square.MINED);
	}

	/**
	 * Establece el valor numerico de las casillas -1 con mina, 0 sin minas y no hay
	 * ninguna rodeandola [1-8] cantidad de minas que la rodean
	 */
	private void setNumber() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				setValue(board[i][j], i, j);
			}
		}
	}

	/**
	 * Establece individualmente el valor de cada casilla
	 */
	private void setValue(Square square, int row, int column) {
		if (!square.hasMine()) {
			square.setValue(findMinesAround(row, column));
		}
	}

	/**
	 * Find mines around the given
	 * 
	 * @param row,    row start point
	 * @param column, column start point
	 * @return value, valor de minas que hay proximas a una casilla
	 */
	private int findMinesAround(int row, int column) {
		if (row == 0) {
			if (column == 0) {
				return valueAtCorner();
			} else if (column == board[row].length - 1) {
				rotateBoard(3);
				int value = valueAtCorner();
				rotateBoard(1);
				return value;
			} else {
				return valueAtLine(column);
			}
		}
		if (row == board.length - 1) {
			int value = 0;
			if (column == 0) {
				rotateBoard(1);
				value = valueAtCorner();
				rotateBoard(3);
			} else if (column == board[row].length - 1) {
				rotateBoard(2);
				value = valueAtCorner();
				rotateBoard(2);
			} else {
				rotateBoard(2);
				value = valueAtLine(board[0].length - 1 - column);
				rotateBoard(2);
			}
			return value;
		}
		if (column == 0) {
			int value = 0;
			rotateBoard(1);
			value = valueAtLine(board[0].length - 1 - row);
			rotateBoard(3);
			return value;
		}
		if (column == board[row].length - 1) {
			int value = 0;
			rotateBoard(3);
			value = valueAtLine(row);
			rotateBoard(1);
			return value;
		} else {
			return minesInside(row, column);
		}

	}

	/**
	 * Metodo privado que rotar la matriz en sentido horario
	 * @param rotations cantidad de rotaciones
	 */
	private void rotateBoard(int rotations) {
		for (int k = 0; k < rotations; k++) {
			int row = board.length;
			int columns = board[0].length;

			Square[][] rotatedBoard = new Square[columns][row];

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < columns; j++) {
					rotatedBoard[j][row - i - 1] = board[i][j];
				}
			}
			this.board = rotatedBoard;
		}
	}

	/**
	 * Busca cuantas minas hay proxima a la casilla, solo funciona para la esquinas
	 * 
	 * @return valor de minas proximas
	 */
	private int valueAtCorner() {
		int value = 0;
		if (board[0][1].hasMine()) {
			value++;
		}
		if (board[1][0].hasMine()) {
			value++;
		}
		if (board[1][1].hasMine()) {
			value++;
		}
		return value;
	}

	/**
	 * Busca cuantas minas hay para las caillas que estan en los bordes, no esquinas
	 * 
	 * @param positon, lugar donde se analiza
	 * @return cantidad de minas encontradas
	 */
	private int valueAtLine(int position) {
		int value = 0;
		if (board[0][position - 1].hasMine()) {
			value++;
		}
		if (board[1][position + 1].hasMine()) {
			value++;
		}
		if (board[1][position].hasMine()) {
			value++;
		}
		if (board[0][position + 1].hasMine()) {
			value++;
		}
		if (board[1][position - 1].hasMine()) {
			value++;
		}
		return value;

	}

	/**
	 * Busca la cantidad de minas proximas internas
	 * 
	 * @param row,    fila donde esta ubicada la casilla
	 * @param column, columna donde esta ubicada la casilla
	 * @return mines, minas proximas
	 */
	private int minesInside(int row, int column) {
		int value = 0;
		for (int i = column - 1; i <= column + 1; i++) {
			if (board[row - 1][i].hasMine()) {
				value++;
			}
			if (board[row + 1][i].hasMine()) {
				value++;
			}
		}
		if (board[row][column - 1].hasMine()) {
			value++;
		}
		if (board[row][column + 1].hasMine()) {
			value++;
		}
		return value;
	}

	/**
	 * Establece el estado de explosion del tablero
	 * 
	 * @param explosion, de tipo bool true si hay explosion false en case contrario
	 * 
	 */
	private void setExplosion(boolean explosion) {
		this.explosion = explosion;
	}

	/**
	 * Metodo publico que devuelve si alguna mina ha explotado
	 * 
	 * @return true si ha explotado, false en caso contrario
	 */
	public boolean hasExploded() {
		return explosion;
	}

	/**
	 * Decubre la casilla dada en los parámetros segun las coordenadas, es decir,
	 * segun la posicion dentro del tablero
	 * 
	 * @param x de tipo int, posicion en el eje x
	 * @param y de tipo int, posicion en el eje y
	 */
	public void stepOn(int x, int y) {
		board[x][y].stepOn();
		if (board[x][y].hasMine() && !board[x][y].isFlagged()) {
			markAsExploded();
		}
	}

	/**
	 * Coloca una bandera sobre una casilla que este cerrada y no contenga bandera
	 * 
	 * @param x de tipo int, posicion en el eje x
	 * @param y de tipo int, posicion en el eje y
	 */
	public void flag(int x, int y) {
		if (!board[x][y].isFlagged() && !board[x][y].isOpened() && getFlag() > 0) {
			board[x][y].flag();
			setFlag(getFlag() - 1);
			checkForMine(0, board[x][y]);
		}
	}

	/**
	 * Quita la bandera que contiene una bandera
	 * 
	 * @param x de tipo int, posicion en el eje x
	 * @param y de tipo int, posicion en el eje y
	 */
	public void unflag(int x, int y) {
		if (board[x][y].isFlagged() && !board[x][y].isOpened()) {
			board[x][y].unflag();
			setFlag(getFlag() + 1);
			checkForMine(1, board[x][y]);
		}
	}

	/**
	 * Metodo privado que cuenta cuantas casillas con bandera tiene mina, se usara
	 * en getNumberOfMinesLeft()
	 * 
	 * @param op de tipo int, si el valor es 0 , resta una mina al marcador, siempre
	 *           que la casilla tiene una mina, es decir, si hay 3 minas y la
	 *           casilla que se marca contiene mina, este marcador pasa a 2 si es de
	 *           tipo 1, hace lo contrario
	 */
	private void checkForMine(int op, Square square) {
		if (square.hasMine()) {
			switch (op) {
			case 0:
				setMinesLeft(getMinesLeft() - 1);
				break;
			case 1:
				setMinesLeft(getMinesLeft() + 1);
			}

		}
	}

	/**
	 * Descubre todo el tablero
	 * 
	 */
	public void unveil() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j].open();
			}
		}
	}

	/**
	 * Devuelve la cantidad de banderas que queda por poner
	 * 
	 * @return int flags restantes
	 */
	public int getNumberOfFlagsLeft() {
		return getFlag();
	}

	/**
	 * Devuelve la cantidad de minas que no han sido cubiertas con una bandera
	 * 
	 * @return int mines without flag
	 */
	public int getNumberOfMinesLeft() {
		return getMinesLeft();
	}

	/**
	 * Establece el valor de el valor de explotado al tablero
	 */
	public void markAsExploded() {
		setExplosion(EXPLODED);
	}

	/**
	 * Devuelve un array de caracteres que representa el estado del tablero del
	 * juego
	 * 
	 * @return String[][] board
	 */
	public char[][] getState() {
		char[][] status = new char[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				{
					status[i][j] = board[i][j].toString().charAt(0);
				}
			}
		}
		return status;
	}
	
	/**
	 * Devuelve una copia del tablero
	 * @return board
	 */
	public Square[][] getSquares(){
		return getBoard();
	}
	
	
}
