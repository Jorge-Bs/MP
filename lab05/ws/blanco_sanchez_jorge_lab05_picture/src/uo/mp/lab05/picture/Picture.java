package uo.mp.lab05.picture;

import java.io.PrintStream;

import uo.mp.lab05.drawing.interfacerepository.Drawable;
import uo.mp.util.check.ArgumentChecks;

public class Picture implements Drawable{
	
	private int x;
	private int y;
	private int width;
	private int heigh;
	private String name;
	
	public Picture(int x,int y, int width, int heigh,String name) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeigh(heigh);
		setName(name);
	}
	
	public void draw(PrintStream out) {
		out.append(String.format("Dibujando la imagen %s en (%d , %d) Dimension: %d*%d", 
				getName(),getX(),getY(),getWidth(),getHeigh()));
	}

	public int getX() {
		return x;
	}

	private void setX(int x) {
		ArgumentChecks.isTrue(x>=0,"invalid x");
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		ArgumentChecks.isTrue(y>=0,"invalid y");
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	private void setWidth(int width) {
		ArgumentChecks.isTrue(width>=0,"invalid width");
		this.width = width;
	}

	public int getHeigh() {
		return heigh;
	}

	private void setHeigh(int heigh) {
		ArgumentChecks.isTrue(heigh>=0,"invalid heigh");
		this.heigh = heigh;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		ArgumentChecks.isTrue(name!=null,"invalid name");
		this.name = name;
	}
	
	

}
