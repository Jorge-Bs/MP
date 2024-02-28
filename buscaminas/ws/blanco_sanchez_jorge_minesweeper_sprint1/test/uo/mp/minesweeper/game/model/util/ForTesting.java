package uo.mp.minesweeper.game.model.util;

import uo.mp.minesweeper.game.model.Square;

public class ForTesting {

	/**
	 * Crea un tablero de casilla, toda ellas sin bandera , sin minas y cerradas
	 * @return Square[4][4]
	 * 
	 */
	public static Square[][] fillBoardClose(){
		Square[][] sq = new Square[4][4];
		for(int i=0;i<sq.length;i++) {
			for(int j=0;j<sq[i].length;j++) {
				sq[i][j]= new Square();
			}
		}
		return sq;
	}
	
	
}
