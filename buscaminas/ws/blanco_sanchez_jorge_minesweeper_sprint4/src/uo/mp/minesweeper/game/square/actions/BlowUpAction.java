package uo.mp.minesweeper.game.square.actions;

import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.util.check.ArgumentChecks;

public class BlowUpAction extends Action{

	private Board board;
	
	/**
	 * Constructor que recibe el tablero
	 * @param board
	 */
	public BlowUpAction(Board board){
		setBoard(board);
	}
	
	/**
	 * Establece el valor del atributo board
	 * @param board
	 */
	private void setBoard(Board board) {
		ArgumentChecks.isTrue(board!=null,"Null board");
		this.board=board;
	}
	/**
	 * Ejecuta la accion, marca el tablero como explotado
	 */
	public void execute() {
		markExplosion();
	}
	
	/**
	 * Marca el tablero como explotado
	 */
	private void markExplosion() {
		this.board.markAsExploded();
	}
	
}


