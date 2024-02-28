package uo.mp.lab05.dome.ui;

import java.io.PrintStream;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Dvd;
import uo.mp.lab05.dome.model.Item;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.model.plataform.Plataform;
import uo.mp.lab05.dome.service.MediaLibrary;

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
	Item cd1 = new Cd("Alchemy", "Dire Straits", 12, 75);
	Item dvd1 = new Dvd("Star Wars", "George Lucas", 125);
	Item vg = new Videogame("Horizon Forbidden West", "Mathijs de Jonge", 1, Plataform.PLAYSTATION);
	// Books
	Item book1 = new Book("titulo1", "135hb-fae", "edbooks", "autor1");
	book1.setOwn(true);
	Item book2 = new Book("titulo2", "13dfhb-fae", "edbooks", "autor2");
	book2.setOwn(true);
	Item book3 = new Book("titulo3", "135asdb-fae", "edbooks", "autor3");
	Item book4 = new Book("titulo4", "1DWED5hb-fae", "edbooks", "autor4");
	Item book5 = new Book("titulo5", "13ffgeshb-fae", "edbooks", "autor5");
	// CD
	cd1.setOwn(true);
	Item cd2 = new Cd("cd2", "autor2", 23, 64);
	cd2.setOwn(true);
	Item cd3 = new Cd("cd3", "autor3", 34, 84);

	ml.add(cd1);
	ml.add(dvd1);
	ml.add(vg);
	ml.add(book1);
	ml.add(book2);
	ml.add(book3);
	ml.add(book4);
	ml.add(book5);
	ml.add(cd2);
	ml.add(cd3);

	ml.borrow(cd1);
	ml.borrow(book1);
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
	out.println(ml.getBorrowables());
	out.println(ml.getAvailables());
    }
}
