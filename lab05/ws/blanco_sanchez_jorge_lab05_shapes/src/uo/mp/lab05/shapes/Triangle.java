package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.lab05.drawing.interfacerepository.Drawable;
import uo.mp.util.check.ArgumentChecks;

public class Triangle extends Shapes implements Drawable {

	
	private int base;
	private int altura;
	
	public Triangle(int x,int y,int base,int altura,Colour colour) {
		super(x,y,colour);
		ArgumentChecks.isTrue(base>0,"Base incorrecta");
		ArgumentChecks.isTrue(altura>0,"Altura incorrecta");
		
		this.base=base;
		this.altura=altura;
	}
	
	public void draw(PrintStream out) {
		String output = (String.format("Drawaing a %s Triangle:(%d,%d) - Base %d - Altura %d",
				this.colour,this.x,this.y,base,altura));
		out.println(output);
	}
}
