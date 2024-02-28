package uo.mp.lab05.dome.model;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

public abstract class Item {

    public static final double MAX_PRICE = 1000;

    private String title;

    boolean gotIt;
    private String comment;

    private double basePrice;

    /**
     * Constructor de la superclase, establece el titulo y el tiempo
     * 
     * @param theTitle
     * @param time
     */
    public Item(String theTitle, int time, double price) {
	setTitle(theTitle);
	setOwn(false);
	setComment("No comment");
	setBasePrice(price);
    }

    /**
     * Constructor de la superclase, establece el titulo
     * 
     * @param title
     */
    public Item(String title, double price) {
	setTitle(title);
	setOwn(false);
	setComment("No comment");
	setBasePrice(price);
    }

    /**
     * Establece el titulo
     * 
     * @param arg String with the new title
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setTitle(String arg) {
	ArgumentChecks.isTrue(arg != null && !arg.isBlank(), "Invalid title");

	this.title = arg;
    }

    /**
     * Establece la propiedad del objeto
     * 
     * @param ownIt de tipo boolean true means we own a copy; otherwise, false
     */
    public void setOwn(boolean ownIt) {
	gotIt = ownIt;
    }

    /**
     * Establece un comentario
     * 
     * @param arg String with a new comment to the element
     *            If the argument is null or does not contain meaningful characters (other than blanks, new lines, etc)
     *            previous comment stays as it is
     */
    public void setComment(String arg) {
	if (arg != null && !arg.isBlank()) {
	    this.comment = arg;
	}
    }

    /**
     * Establece el precio del item
     * 
     * @param basePrice de tipo double
     */
    private void setBasePrice(double basePrice) {
	ArgumentChecks.isTrue(basePrice > 0 && basePrice <= MAX_PRICE, "Invalid price");
	this.basePrice = basePrice;
    }

    /**
     * Devuelve el precio del item
     * 
     * @return basePrice
     */
    protected double getBasePrice() {
	return basePrice;
    }

    /**
     * Retorna el comentario
     * 
     * @return the comment (if any) or default
     */
    public String getComment() {
	return comment;
    }

    /**
     * Retorna true si lo tienes en posesion
     * 
     * @return true if we own a copy; false otherwise
     */
    public boolean getOwn() {
	return gotIt;
    }

    /**
     * Retorna el titulo
     * 
     * @return title
     */
    public String getTitle() {
	return this.title;
    }

    /**
     * Devuelve un string con el codigo del objeto
     * 
     * @param index posicion del objeto, es un valor que se a�ade al id
     * @return code con el id del objeto
     */
    public String code(int index) {
	StringBuilder sb = new StringBuilder();
	if (this.getTitle()
	    .length() >= 3) {
	    sb.append(this.getTitle()
		.substring(0, 3) + index);
	} else {
	    sb.append(this.getTitle()
		.substring(0, getTitle().length()) + index);
	}
	return sb.toString();
    }

    /**
     * Metodo abstracto para imprimir la informacion de los objetos
     * 
     * @param out de tipo PrintStream
     */
    public abstract void print(PrintStream out);

    /**
     * Devuelve una Sring con el autor del item
     * 
     * 
     * @return un string con los datos del autor
     */
    public abstract String getResponsable();

    /**
     * Método Equals para saber si dos objetos son iguales
     * 
     * @param itm a comparar
     */
    public boolean equals(Item itm) {
	return this.equals(itm);
    }

    /**
     * devuelve el precio final del item
     * 
     * @return price de tipo double
     */
    public abstract double getFinalPrice();

    // public abstract boolean isLike();
}