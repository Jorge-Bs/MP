package uo.mp.lab04.dome.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab04.dome.model.plataform.Plataform;

public class Videogame extends Item {
    public static final double PRICE = 50;
    public static final double TAX = 1.1;

    private String creator;
    private int players;
    private Plataform plataform;

    /**
     * Constructor que recibe el titulo, creador, posesion, numero de jugadores y plataforma
     * 
     * @param title,     titulo
     * @param creator,   creador
     * @param players,   jugadores
     * @param plataform, plataforma de juego
     */
    public Videogame(String title, String creator, int players, Plataform plataform) {
	super(title, PRICE);
	setCreator(creator);
	setPlayers(players);
	setPlataform(plataform);
    }

    /**
     * Establece el valor del creador
     * 
     * @param creador
     */
    private void setCreator(String creator) {
	ArgumentChecks.isTrue(creator != null && !creator.isBlank(), "Creador invalido");
	this.creator = creator;
    }

    /**
     * Establece el numero de jugadores
     * 
     * @param players
     */
    private void setPlayers(int players) {
	this.players = players;
    }

    /**
     * Establece la plataforma
     * 
     * @param plataform
     */
    private void setPlataform(Plataform plataform) {
	ArgumentChecks.isTrue(plataform != null, "Plataforma invalida");
	this.plataform = plataform;
    }

    /**
     * Devuelve el creador
     * 
     * @return creator
     */
    public String getCreator() {
	return creator;
    }

    /**
     * Devuelve los jugadores
     * 
     * @return players
     */
    public int getPlayers() {
	return players;
    }

    /**
     * Devuelve la plataforma de juego
     * 
     * @return plataforma de juego
     */
    public Plataform getPlataform() {
	return plataform;
    }

    /**
     * Devuelve el precio final del objto
     * 
     * @return price
     */
    public final double getFinalPrice() {
	return getBasePrice() * TAX;
    }

    /**
     * Devuelve el precio del objeto
     */

    /**
     * Devuelve un String con la informacion del objeto
     * 
     * @return String
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Videogame\n" + getTitle());
	builder.append("\nCreator: " + getCreator());
	builder.append("\nPlataform: " + getPlataform());
	builder.append("\nPlayers: " + getPlayers());
	if (getOwn()) {
	    builder.append("\nYou own it");
	} else {
	    builder.append("\nYou do not own it");
	}
	builder.append("\nComment: " + getComment());
	return builder.toString();
    }

    /**
     * Metodo para impimir la informacion del videojuego
     * 
     * @param out de tipo Printstream donde se almacena la informacion
     */
    @Override
    public void print(PrintStream out) {
	out.println(toString());
    }

    /**
     * Devuelve el autor del juego
     * 
     * @return autor
     */
    @Override
    public String getResponsable() {
	return getCreator();
    }

    /**
     * Devuelve true si los objetos son iguales o contiene la misma informacion
     * 
     * @param videogame a comparar
     */
    @Override
    public boolean equals(Item videogame) {
	if (videogame == null) {
	    return false;
	} else if (this == videogame) {
	    return true;
	} else if (!(videogame instanceof Videogame)) {
	    return false;
	} else {
	    Videogame videogame1 = (Videogame) videogame;
	    return (this.getTitle()
		.equals(videogame1.getTitle())
		    && this.getPlataform()
			.equals(videogame1.getPlataform()));
	}
    }

//    /**
//     * Método isLike
//     */
//    public boolean isLike(Item videogame) {
//	if (videogame == null) {
//	    return false;
//	} else if (this == videogame) {
//	    return true;
//	} else if (!(videogame instanceof Videogame)) {
//	    return false;
//	} else {
//	    Videogame videogame1 = (Videogame) videogame;
//	    return (this.getTitle() == videogame1.getTitle() && this.getPlataform() == videogame1.getPlataform());
//	}
//    }

}