package uo.mp.minesweeper.game.square.actions;

import java.util.List;


import uo.mp.minesweeper.game.square.Square;
import uo.mp.minesweeper.util.check.ArgumentChecks;

public class ClearAction extends Action{

	private List<Square> neighbouringSquares;
	private boolean activate=false;
	
	public  ClearAction(List<Square> neighbouringSquares) {
		setNeighbouringSquares(neighbouringSquares);
		setActivate(false);
	}
	
	
	/**
	 * Ejecuta la accion de la casilla, en esta clase se encarga de destapar las casillas
	 */
	public void execute() {
		if(!activate) {
			for(Square neighbour:neighbouringSquares) {
				neighbour.stepOn();
			}
			activate();
		}
	}


	/**
	 * Establece las lista de las casillas vecinas
	 * @param neighbouringSquares
	 */
	private void setNeighbouringSquares(List<Square> neighbouringSquares) {
		ArgumentChecks.isTrue(neighbouringSquares!=null,"Error con las casillas vecinas");
		this.neighbouringSquares = neighbouringSquares;
	}
	
	/**
	 * Eestablece el estado de la accion como activada, se hace para evitar que pueda entrar en bucle o
	 * que se realiza la operacion varias veces
	 */
	private void activate() {
		activate=true;
		
	}
	
	/**
	 * Establece el estado
	 * @pararm status de tipo boolean
	 */
	private void setActivate(boolean status) {
		activate=status;
	}
	
	
	
}
