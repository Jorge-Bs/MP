package uo.mp.minesweeper.game.model.util;

import uo.mp.minesweeper.game.square.Square;

public class ForTesting {

	/**
	 * Crea un tablero de casilla, toda ellas sin bandera , sin minas y cerradas
	 * @param x de tipo int, tamaño del tablero
	 * @return Square[x][x]
	 * 
	 */
	public static Square[][] fillBoardClose(int x){
		Square[][] sq = new Square[x][x];
		for(int i=0;i<sq.length;i++) {
			for(int j=0;j<sq[i].length;j++) {
				sq[i][j]= new Square();
			}
		}
		return sq;
	}
	
	
}
