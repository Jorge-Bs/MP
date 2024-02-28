package uo.mp.lab05.dome.service.medialibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Dvd;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.model.plataform.Plataform;
import uo.mp.lab05.dome.service.MediaLibrary;

public class GeneratCodesTest {

    private Cd cd1;
    private Dvd dvd1;
    private Videogame vg;
    private MediaLibrary ml;

    @BeforeEach
    public void setUp() {
	ml = new MediaLibrary();

	cd1 = new Cd("Alchemy", "Dire Straits", 12, 75);
	cd1.setOwn(true);

	dvd1 = new Dvd("Star Wars", "George Lucas", 125);

	vg = new Videogame("Horizon Forbidden West", "Mathijs de Jonge", 1, Plataform.PLAYSTATION);
	vg.setOwn(true);

	ml.add(cd1);
	ml.add(dvd1);
	ml.add(vg);
    }

    /**
     * Given: un mediaLibrary con objetos
     * When: se invoca al metodo
     * Then: se comprueba que se genera la misma cadena
     */
    @Test
    public void codeWithItems() {
	String id = ("Código Generado por los Items: \nAlc0-Sta1-Hor2");
	assertEquals(id, ml.generateCodes());
    }

    /**
     * Given: un medialibrary vacio
     * When: se invoca al metodo
     * Then: devuelve la cadena Código Generado por los Items: sin ningun id
     */
    @Test
    public void nullItems() {
	MediaLibrary ml1 = new MediaLibrary();
	assertEquals("Código Generado por los Items: \n", ml1.generateCodes());
    }

    /**
     * Given: un mediaLibrary con onjetos, donde uno de ellos tine un titulo corto
     * When: se invoca al metodo
     * Then: devuelve la cadena con los ids
     */
    @Test
    public void codeWithItemsAndOneShort() {
	String id = ("Código Generado por los Items: \nAlc0-Sta1-Hor2-Fe3");
	ml.add(new Cd("Fe", "author1", 15, 23));
	assertEquals(id, ml.generateCodes());
    }

}
