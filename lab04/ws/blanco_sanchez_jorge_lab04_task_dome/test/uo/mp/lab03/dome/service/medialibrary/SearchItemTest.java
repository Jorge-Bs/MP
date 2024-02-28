package uo.mp.lab03.dome.service.medialibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.dome.model.Cd;
import uo.mp.lab04.dome.model.Dvd;
import uo.mp.lab04.dome.model.Videogame;
import uo.mp.lab04.dome.model.plataform.Plataform;
import uo.mp.lab04.dome.service.MediaLibrary;

public class SearchItemTest {
    private Cd cd1;
    private Dvd dvd1;
    private Videogame vg;
    private MediaLibrary ml;

    @BeforeEach
    public void setUp() {
	ml = new MediaLibrary();
	cd1 = new Cd("Alchemy", "Dire Straits", 12, 75);
	dvd1 = new Dvd("Star Wars", "George Lucas", 120);
	vg = new Videogame("Horizon Forbidden West", "Mathijs de Jonge", 1, Plataform.PLAYSTATION);
	ml.add(cd1);
	ml.add(dvd1);
	ml.add(vg);
    }

    /**
     * Given: Un mediaLibrary con un dvd y un cd
     * When: se busca el objeto dvd y cd
     * Then: nos devuelve el objeto
     */
    @Test
    public void findItemEqual() {
	assertEquals(dvd1, ml.searchItem(dvd1));
	assertEquals(cd1, ml.searchItem(cd1));
	assertEquals(vg, ml.searchItem(vg));
    }

    /**
     * Given: Un mediaLibrary con un dvd y un cd
     * When: se busca el objeto dvd y cd, pero se busca una copia de ellos
     * Then: nos devuelve null
     */
    @Test
    public void findItemsClone() {
	Dvd dvd3 = new Dvd("Star Wars", "George Lucas", 120);
	Cd cd3 = new Cd("Alchemy", "Dire Straits", 12, 75);
	Videogame vg1 = new Videogame("Horizon Forbidden West", "Mathijs de Jonge", 1, Plataform.PLAYSTATION);
	assertEquals(dvd1, ml.searchItem(dvd3));
	assertEquals(cd1, ml.searchItem(cd3));
	assertEquals(vg, ml.searchItem(vg1));
    }

    /**
     * Given: un medialibrary
     * When: se busca con el parametro null
     * Then: salta error
     */
    @Test
    public void findItemNull() {
	try {
	    ml.searchItem(null);
	    fail("Debería haber fallado");
	} catch (IllegalArgumentException e) {
	    assertEquals("Objeto Invalido", e.getMessage());
	}
    }

}
