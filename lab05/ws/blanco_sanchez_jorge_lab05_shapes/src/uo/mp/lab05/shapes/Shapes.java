package uo.mp.lab05.shapes;


import uo.mp.util.check.ArgumentChecks;

public abstract class Shapes {

	/**
	 * The x coordinate of the upper-left corner.
	 */
	protected int x;

	/**
	 * The y coordinate of the upper-left corner.
	 */
	protected int y;
	
	protected Colour colour;
	
	public Shapes(int x,int y,Colour colour) {
		ArgumentChecks.isTrue(x >= 0);
		ArgumentChecks.isTrue(y >= 0);
		ArgumentChecks.isTrue(colour != null);
		
		this.x=x;
		this.y=y;
		this.colour=colour;
		
	}
}
