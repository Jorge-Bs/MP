package uo.mp.lab05.client;

import uo.mp.lab05.drawing.software.Canvas;
import uo.mp.lab05.picture.Picture;
import uo.mp.lab05.shapes.Circle;
import uo.mp.lab05.shapes.Colour;
import uo.mp.lab05.shapes.Rectangle;
//import uo.mp.lab05.shapes.Triangle;
import uo.mp.lab05.shapes.Triangle;

public class Main {
	
	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		Canvas drawing = new Canvas();

		drawing.add( new Rectangle(1, 2, 3, 6, Colour.BLACK) );
		drawing.add( new Rectangle(3, 4, 7, 8, Colour.YELLOW) );
		drawing.add( new Circle(5, 5, 2, Colour.RED) );
		drawing.add( new Triangle(5, 5, 5, 7, Colour.GREEN) );
		drawing.add( new Picture(10, 10, 100, 75, "picture1.jpg") );

		drawing.draw(System.out);
		
	}
}
