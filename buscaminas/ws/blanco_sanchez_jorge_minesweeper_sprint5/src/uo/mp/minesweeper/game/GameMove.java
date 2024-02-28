package uo.mp.minesweeper.game;

import uo.mp.minesweeper.util.check.ArgumentChecks;

public class GameMove {
	
	private char operation;
	private int row;
	private int column;

	

	/**
	 * Constructor que recibe los siguientes parametros:
	 * @param operation
	 * @param row
	 * @param column
	 */
	public GameMove(char operation,int row,int column) {
		setOperation(operation);
		setRow(row);
		setColumn(column);
	}
	
	/**
	 * Devuelve el char correspondiente a la operacion
	 * @return operation de tipo char
	 */
	public char getOperation() {
		return operation;
	}

	/**
	 * Devuelve el valor de posicion en la fila
	 * @return row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Devuelve el valor de posicion en la columna
	 * @return column
	 */
	public int getColumn() {
		return column;
	}

	
	
	/**
	 * Devuelve una cadena de texto con la informacion de accion y la casilla seleccionada
	 * @return string con la accion a realizar sobre la casilla
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GameMove [operation="+getOperation());
		builder.append(", row="+getRow());
		builder.append(", column="+getColumn()+"]");
		return builder.toString();
	}

	/**
	 * Establece la operacion, solo se permite (s,f,u)
	 * @param operation
	 */
	private void setOperation(char operation) {
		ArgumentChecks.isTrue(validCharacter(operation),"Invalid characters");
		this.operation = operation;
	}

	/**
	 * Establece el valor de la fila
	 * @param row
	 */
	private void setRow(int row) {
		ArgumentChecks.isTrue(row>=0,"Posicion de fila invalida");
		this.row = row;
	}

	/**
	 * Establece el valor de la columna
	 * @param column
	 */
	private void setColumn(int column) {
		ArgumentChecks.isTrue(row>=0,"Posicion de columna invalida");
		this.column = column;
	}
	
	
	/**
	 * Devuelve true si los caracteres son validos
	 * @param character a analizar
	 * @return true si lo es, false en caso contrario
	 */
	private boolean validCharacter(char character) {
		return (character=='s'||character=='f'||character=='u');
	}
	
	
}
