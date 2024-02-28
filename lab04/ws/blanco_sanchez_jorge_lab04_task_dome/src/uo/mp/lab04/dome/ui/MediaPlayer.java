package uo.mp.lab04.dome.ui;

import java.io.PrintStream;

import uo.mp.lab04.dome.model.Cd;
import uo.mp.lab04.dome.model.Dvd;
import uo.mp.lab04.dome.model.Videogame;
import uo.mp.lab04.dome.model.plataform.Plataform;
import uo.mp.lab04.dome.service.MediaLibrary;

public class MediaPlayer {

    private MediaLibrary ml;

    /**
     * Inicializa un mediaPlayer basico
     */
    public void run() {
	create();
	add();
	information();

    }

    /**
     * crea el mediaLibrary
     * 
     */
    private void create() {
	ml = new MediaLibrary();
    }

    /**
     * añade un elemento de cada clase al media libray,
     * 
     */
    private void add() {
	Cd cd1 = new Cd("Alchemy", "Dire Straits", 12, 75);
	Dvd dvd1 = new Dvd("Star Wars", "George Lucas", 125);
	Videogame vg = new Videogame("Horizon Forbidden West", "Mathijs de Jonge", 1, Plataform.PLAYSTATION);
	ml.add(cd1);
	ml.add(dvd1);
	ml.add(vg);
    }

    /**
     * Devuelve la informacion respecto a los items
     * Objetos en posesion
     * Responsables
     * Listado
     */
    private void information() {
	int own = ml.getNumberOfItemsOwned();
	String responsables = ml.getResponsables();
	PrintStream out = new PrintStream(System.out);
	out.println("Owned: " + own);
	out.println(responsables);
	out.println(ml.generateCodes() + "\n");
	ml.list(out);
    }
}
