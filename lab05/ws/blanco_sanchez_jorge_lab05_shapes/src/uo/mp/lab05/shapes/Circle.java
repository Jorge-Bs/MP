package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.lab05.drawing.interfacerepository.Drawable;
import uo.mp.util.check.ArgumentChecks;

public class Circle extends Shapes implements Drawable {



	private int radio;

	

	/**
	 * Creates a new rectangle
	 * @param x x coordinate of the lower left corner
	 * @param y y coordinate of the lower left corner
	 * @param radio de tipo int
	 * @param colour 
	 * @throws IAE if some argument is illegal
	 * 			coordinates, width, height is 0 or under 0
	 * 			colour is null
	 */
	public Circle(int x, int y, int radio, Colour colour) {
		
		super(x,y,colour);
		ArgumentChecks.isTrue(radio >= 0);
		

		this.radio=radio;
	}
	
	public void draw(PrintStream out) {
		String output = String.format("Drawing a %s Circle: (%d, %d) - Radio: %d", 
				this.colour, 
				this.x, 
				this.y, 
				this.radio);
		out.println(output);
	}
	
}
