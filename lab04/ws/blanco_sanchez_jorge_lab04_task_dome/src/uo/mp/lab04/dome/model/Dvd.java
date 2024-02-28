package uo.mp.lab04.dome.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;

public class Dvd extends Item {
    public static final double PRICE = 40;
    public static final int TAX = 0;

    private String director;
    private int playingTime;

    /**
     * Creates a new Dvd with default values for gotIt and comment
     * 
     * @param theTitle    String for title
     * @param theDirector String for director
     * @param time        integer for time
     */
    public Dvd(String theTitle, String theDirector, int time) {
	super(theTitle, PRICE);
	setPlayingTime(time);
	setDirector(theDirector);
    }

    /**
     * Develve el tiempo del cd
     * 
     * @return playingTime
     */
    public int getPlayingTime() {
	return playingTime;
    }

    /**
     * Establece el tiempo
     * 
     * @parama playingTime de tipo int
     */
    private void setPlayingTime(int playingTime) {
	ArgumentChecks.isTrue(playingTime > 0, "Invalid playing time");
	this.playingTime = playingTime;
    }

    /**
     * Establece el director
     * 
     * @param arg String with the new director
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setDirector(String arg) {
	ArgumentChecks.isTrue(arg != null && !arg.isBlank(), "Invalid director");
	this.director = arg;
    }

    /**
     * Retorna el director
     * 
     * @return the director of the dvd
     */
    public String getDirector() {
	return this.director;
    }

    /**
     * Devuelve el precio final del objeto
     * 
     * @return price
     */
    public final double getFinalPrice() {
	return getBasePrice() + TAX;
    }

    /**
     * ToString devuelve una cadena con la informacion del objeto
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Dvd \nTitle: " + getTitle() + "\nDirector: " + getDirector());
	builder.append("\nTime: " + getPlayingTime() + " (mins)");
	builder.append("\nComment: " + getComment());
	if (getOwn()) {
	    builder.append("\nYou own it\n");
	} else {
	    builder.append("\nYou do not own it\n");
	}
	return builder.toString();
    }

    /**
     * @param out a PrintStream to flush output
     */
    @Override
    public void print(PrintStream out) {
	out.println(toString());
    }

    /**
     * Devuelve el autor del CD
     * 
     * @return String autor
     */
    @Override
    public String getResponsable() {
	return getDirector();
    }

    /**
     * Devuelve true si los objetos son iguales o contiene la misma informacion
     * 
     * @param dvd a comparar
     */
    @Override
    public boolean equals(Item dvd) {
	if (dvd == null) {
	    return false;
	} else if (this == dvd) {
	    return true;
	} else if (!(dvd instanceof Dvd)) {
	    return false;
	} else {
	    Dvd dvd1 = (Dvd) dvd;
	    return (this.getDirector()
		.equals(dvd1.getDirector())
		    && this.getDirector()
			.equals(dvd1.getDirector()));
	}
    }

//    /**
//     * Método isLike
//     */
//    public boolean isLike(Item dvd) {
//	if (dvd == null) {
//	    return false;
//	} else if (this == dvd) {
//	    return true;
//	} else if (!(dvd instanceof Dvd)) {
//	    return false;
//	} else {
//	    Dvd dvd1 = (Dvd) dvd;
//	    return (this.getDirector() == dvd1.getDirector() && this.getDirector() == dvd1.getDirector());
//	}
//    }

}
