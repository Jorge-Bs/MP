package uo.mp.lab05.dome.service.medialibrary;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Dvd;
import uo.mp.lab05.dome.model.Item;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.model.plataform.Plataform;
import uo.mp.lab05.dome.service.MediaLibrary;

public class AddTest {

    private Cd cd1;
    private Dvd dvd1;
    private Videogame vg;
    private MediaLibrary ml, ml2;

    @BeforeEach
    public void setUp() {
	ml = new MediaLibrary();
	ml2 = new MediaLibrary();
	cd1 = new Cd("Alchemy", "Dire Straits", 12, 75);
	dvd1 = new Dvd("Star Wars", "George Lucas", 125);
	vg = new Videogame("Horizon Forbidden West", "Mathijs de Jonge", 1, Plataform.PLAYSTATION);
	ml2.add(cd1);
    }

    /**
     * Given a medialibrary empty
     * when a dvd is added
     * then the dvd is saved in the list
     */
    @Test
    public void addItenOnNewCollection() {
	assertEquals(0, ml.getItemsForTesting()
	    .size());

	ml.add(cd1);
	ml.add(dvd1);
	ml.add(vg);

	List<Item> items = ml.getItemsForTesting();
	assertTrue(cd1 == items.get(0));
	assertTrue(dvd1 == items.get(1));
	assertTrue(vg == items.get(2));

	assertEquals(3, ml.getItemsForTesting()
	    .size());
    }

    /**
     * Given: a medialibrary with item
     * when: se añade otro
     * Tehn: aumenta en uno la coleccion
     */
    @Test
    public void addItemInCollection() {
	ml2.add(dvd1);
	assertEquals(2, ml2.getItemsForTesting()
	    .size());
	assertEquals(dvd1, ml2.getItemsForTesting()
	    .get(1));
    }

    /**
     * Gieven a medialibrary
     * When: se invoca con null
     * Then: salta error
     */
    @Test
    public void addNullItem() {
	try {
	    ml.add(null);
	    fail("deberia haber fallado");
	} catch (IllegalArgumentException e) {
	    assertEquals("invalid item", e.getMessage());
	}
    }

}
