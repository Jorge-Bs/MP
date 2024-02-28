package uo.mp.lab04.dome.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;

public class Cd extends Item {
    public static final double PRICE = 20;
    public static final int TAX = 2;

    private String artist;
    private int numberOfTracks;
    private int playingTime;

    /**
     * Creates a new Cd with default values for gotIt and comment
     * 
     * @param theTitle  String for title
     * @param theArtist String for artist
     * @param tracks    integer for tracks
     * @param time      integer for time
     */
    public Cd(String theTitle, String theArtist, int tracks, int time) {
	super(theTitle, PRICE);

	setPlayingTime(time);
	setArtist(theArtist);
	setNumberOfTracks(tracks);

    }

    /**
     * Establece el artista
     * 
     * @param arg String with the new artist name
     * @throws IllegalArgumentException if the argument is null, 0-length or does not contain meaningful characters
     */
    private void setArtist(String arg) {
	ArgumentChecks.isTrue(arg != null && !arg.isBlank(), "Invalid artist");

	this.artist = arg;
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
     * Establece las canciones
     * 
     * @param arg integer with the number of tracks in the CD
     * @throws IllegalArgumentException if the argument is is lower or equal zero
     */
    private void setNumberOfTracks(int arg) {
	ArgumentChecks.isTrue(arg > 0, "Invalid number of tracks");
	this.numberOfTracks = arg;
    }

    /**
     * devuelve el artista de la cancion
     * 
     * @return String artist's name
     */
    public String getArtist() {
	return this.artist;
    }

    /**
     * devuelve el numero de canciones
     * 
     * @return number of tracks
     */
    public int getNumberOfTracks() {
	return this.numberOfTracks;
    }

    /**
     * Devuelve el precio final del objto
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
	builder.append("Cd \nTitle: " + getTitle() + "\nArtist: " + getArtist());
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
     * Imprime la informacion del disco
     * 
     * @param out a PrintStream to flush output
     */
    public void print(PrintStream out) {
	out.println(toString());
    }

    /**
     * Devuelve el autor del DVD
     * 
     * @return String autor
     */
    public String getResponsable() {
	return getArtist();
    }

    /**
     * Devuelve true si los objetos son iguales o contiene la misma informacion
     * 
     * @param cd a comparar
     */
    @Override
    public boolean equals(Item cd) {
	if (cd == null) {
	    return false;
	} else if (this == cd) {
	    return true;
	} else if (!(cd instanceof Cd)) {
	    return false;
	} else {
	    Cd cd1 = (Cd) cd;
	    return (this.getArtist()
		.equals(cd1.getArtist())
		    && this.getTitle()
			.equals(cd1.getTitle()));
	}
    }

//    /**
//     * Método isLike
//     */
//    public boolean isLike(Item cd) {
//	if (cd == null) {
//	    return false;
//	} else if (this == cd) {
//	    return true;
//	} else if (!(cd instanceof Cd)) {
//	    return false;
//	} else {
//	    Cd cd1 = (Cd) cd;
//	    return (this.getArtist() == cd1.getArtist() && this.getTitle() == cd1.getTitle());
//	}
//    }
}