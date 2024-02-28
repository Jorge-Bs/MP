package uo.mp.minesweeper.game.model;

import uo.mp.minesweeper.util.check.ArgumentChecks;

/**
 * Clase Square
 * Contiene el comportamiento individual de cada una de las casillas y su correspondiente estado
 * 
 * @author Jorge Blanco Sánchez
 *
 */
public class Square {
	public static final boolean FLAGGED = true;
	public static final boolean UNFLAGGED = !FLAGGED;
	
	public static final boolean OPENED = true;
	public static final boolean CLOSED = !OPENED;
	
	public static final int MINED = -1;
	public static final int NOT_MINED = 0;
	public static final int MAX_STATUS_MINE=8;
	
	private boolean flagStatus;
	private boolean openStatus;
	private int mineStatus;
	
	/**
	 * Constructor que inicializa una casilla con el estado cerrado y sin mina
	 */
	public Square() {
		setOpenStatus(CLOSED);
		setFlagStatus(UNFLAGGED);
		setMineStatus(NOT_MINED);
	}
	
	/**
	 * Constructor que recibe los parametros, uso para clonar las casillas
	 * @param open, si esta abierta
	 * @param flagged, si contiene bandera
	 * @param value, valor numerico de la casilla
	 */
	private Square(boolean open,boolean flagged,int value) {
		this();
		setOpenStatus(open);
		setFlagStatus(flagged);
		setMineStatus(value);
	}
	
	
	/**
	 * Establece el estado de la casilla en abierta o cerrada
	 * @param openStatus, de tipo boolean establece el estado
	 */
	private void setOpenStatus(boolean openStatus) {
		this.openStatus=openStatus;
	}
	
	/**
	 * Establece si la casilla tiene bandera o no
	 * @param flagStatus
	 */
	private void setFlagStatus(boolean flagStatus) {
		this.flagStatus=flagStatus;
	}
	
	
	/**
	 * Setter que establece el estado de la mina,
	 * 		0-Sin mina
	 * 		[1-8]-Minas que hay a su alrededor
	 * 		-1 Con mina
	 * @param mineStatus, de tipo int, establece el estado
	 */
	private void setMineStatus(int mineStatus) {
		this.mineStatus=mineStatus;
	}
	
	/**
	 * Metodo que devuelve el estado de la casilla, abierta o cerrada,
	 * 
	 * @return boolean, true si esta abierta, false si no lo esta
	 */
	public boolean isOpened() {
		return openStatus;
	}
	
	
	/**
	 * Metodo que devuelve el estado de la casilla, con bandera o sin ella,
	 * 
	 * @return boolean, true si la tiene, false si no la tiene
	 */
	public boolean isFlagged() {
		return flagStatus;
	}
	
	/**
	 * Metodo privado que devuelve el estado de la casilla para saber si tiene mina, esta vacia
	 * 	o tiene alguna proxima
	 * 
	 * @return int, 0 si no hay mina,-1 si la hay o [1-8] cuantas hay proximas
	 */
	private int getMineStatus() {
		return mineStatus;
	}
	
	/**
	 * MÃ©todo public que devuelve el estdo numerico de la casilla
	 * 
	 * @return int, 0 si no hay mina,-1 si la hay o [1-8] cuantas hay proximas
	 */
	public int getValue() {
		return getMineStatus();
	}
	/**
	 * Metodo que devuelve si hay presente una mina(true) o  si no la hay(false)
	 * 
	 * @return boolean, true si contiene mina,false en caso contrario
	 */
	public boolean hasMine() {
		return (getMineStatus()==MINED)? true:false;
	}
	
	/**
	 * Establece el estado abierto en la casilla, siempre que que se encuentre cerrada y sin bandera
	 */
	public void stepOn() {
		if(!isOpened() && !isFlagged()) {
			setOpenStatus(OPENED);
		}
	}
	
	/**
	 * Establece el estado con bandera de la casilla
	 */
	public void flag() {
		if(!isOpened()) {
			setFlagStatus(FLAGGED);
		}
	}
	/**
	 * Establece el estado sin bandera de la casilla 
	 */
	public void unflag() {
		if(!isOpened()&&isFlagged()) {
			setFlagStatus(UNFLAGGED);
		}
	}
	
	/**
	 * Establece, sea el estado en el que se encuentra la casilla, en abierto
	 */
	public void open() {
		setOpenStatus(OPENED);
		setFlagStatus(UNFLAGGED);
	}
	
	/**
	 * Devuelve la String correspondiente al estado de la mina:
	 * #-casilla cerrada, numero entre [1-8] minas que le rodean, " "si no hay mina y miguna proxima 
	 * 		o @-si tiene una mina
	 * @return String, con el formato anterior
	 */
	public String toString() {
		return  valueToString();
	}
	
	/**
	 * Metodo privado que devuelve el estado de la casilla en un caracter
	 * #-casilla cerrada, numero entre [1-8] minas que le rodean, " "si no hay mina y miguna proxima 
	 * 		o @-si tiene una mina
	 * @return String, # , [1-8]," " o @
	 */
	private String valueToString() {
		if(isOpened()) {
			if(!hasMine())
				return (getMineStatus()!=0)? String.format("%s",getMineStatus()):" ";
			else {
		
				return "@";
			}
		}
		else if(isFlagged()) {
			return Character.toString((char) 182);
		}
		else {
			return "#";
		}
	}
	
	/**
	 * Metodo publico que establece el estado con mina
	 * 
	 */
	public void putMine() {
		setMineStatus(MINED);
	}
	
	/**
	 * Metodo publico que estable el valor numerico de la casilla
	 * @param value, de tipo int entre[-1,8]
	 */
	public void setValue(int value) {
		ArgumentChecks.isTrue(value>=MINED && value<=MAX_STATUS_MINE, "valor de mina no permitido");
		setMineStatus(value);
	}
	
	/**
	 * Clona un objeto
	 * @param objeto a clonar
	 * @return copy del objeto
	 */
	protected Square clone(){
		Square copy = new Square(isOpened(),isFlagged(),getValue());
		return copy;
	}
	
}
