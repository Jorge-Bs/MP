package uo.mp.lab05.dome.service.medialibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Dvd;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.model.plataform.Plataform;
import uo.mp.lab05.dome.service.MediaLibrary;

public class GetResponsablesTest {

    private Cd cd1;
    private Dvd dvd1;
    private Videogame vg;
    private MediaLibrary ml;

    @BeforeEach
    public void setUp() {
	ml = new MediaLibrary();

	cd1 = new Cd("Alchemy", "Dire Straits", 12, 75);
	dvd1 = new Dvd("Star Wars", "George Lucas", 125);
	vg = new Videogame("Horizon Forbidden West", "Mathijs de Jonge", 1, Plataform.PLAYSTATION);

	ml.add(cd1);
	ml.add(dvd1);
	ml.add(vg);
    }

    /**
     * Given: un medialibrary con elementos
     * When: se invoca al metodo
     * Then: devuelve un String con los autores
     */
    @Test
    public void testGetResponsablesWithItems() {
	String result = "Responsables: Dire Straits, George Lucas, Mathijs de Jonge";
	assertEquals(result, ml.getResponsables());
    }

    /**
     * Gieven: una coleccion vacia
     * When: se invoca al metodo
     * Then: devuelve una String vacia
     */
    @Test
    public void testGetResponsablesWithouItems() {
	MediaLibrary ml1 = new MediaLibrary();
	String result = "Responsables: No responsables found";
	assertEquals(result, ml1.getResponsables());
    }

    /**
     * Gieven: una coleccion con un item
     * When: se invoca al metodo
     * Then: devuelve una String vacia
     */
    @Test
    public void testGetResponsablesWitOneItem() {
	MediaLibrary ml1 = new MediaLibrary();
	ml1.add(vg);
	String result = "Responsables: Mathijs de Jonge";
	assertEquals(result, ml1.getResponsables());
    }
}
