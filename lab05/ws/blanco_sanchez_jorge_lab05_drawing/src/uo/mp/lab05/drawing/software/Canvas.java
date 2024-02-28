package uo.mp.lab05.drawing.software;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab05.drawing.interfacerepository.Drawable;


public class Canvas {
	private List< Drawable > drawables = new ArrayList<>();

	/**
	 * Adds to the canvas a new object to be drawn 
	 * @param drawable something that can be drawn
	 * @throws IAE if argument is null
	 */
	public void add(Drawable drawable) {
		drawables.add(drawable);
	}

	/**
	 * Prints the content in the canvas
	 * @implNote it will print in console the description of the items  
	 * @param out output
	 */
	public void draw(PrintStream out) {
		for(Drawable shape:drawables) {
			shape.draw(out);
		}
	}
}
