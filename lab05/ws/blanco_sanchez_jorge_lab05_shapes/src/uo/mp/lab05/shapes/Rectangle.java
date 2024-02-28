package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.lab05.drawing.interfacerepository.Drawable;
import uo.mp.util.check.ArgumentChecks;

/**
 * A rectangle specifies an area in a coordinate space that is enclosed by the
 * the rectangle upper-left point (x, y) in the coordinate space, its width, and
 * its height.
 */
public class Rectangle extends Shapes implements Drawable{
	

	/**
	 * The width of the rectangle, in pixels.
	 */
	private int width;

	/**
	 * The height of the rectangle, in pixels.
	 */
	private int height;



	/**
	 * Creates a new rectangle
	 * @param x x coordinate of the lower left corner
	 * @param y y coordinate of the lower left corner
	 * @param width of the shape, in pixels
	 * @param height height of the rectangle, in pixels
	 * @param colour 
	 * @throws IAE if some argument is illegal
	 * 			coordinates, width, height is 0 or under 0
	 * 			colour is null
	 */
	public Rectangle(int x, int y, int width, int height, Colour colour) {
		super(x,y,colour);
		ArgumentChecks.isTrue(width >= 0);
		ArgumentChecks.isTrue(height >= 0);

		this.width = width;
		this.height = height;
	}
	
	public void draw(PrintStream out) {
		String output = String.format("Drawing a %s Rectangle: (%d, %d) - width: %d - height: %d", 
				this.colour, 
				this.x, 
				this.y, 
				this.width, 
				this.height);
		out.println(output);
	}

}
