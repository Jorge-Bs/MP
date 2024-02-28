package uo.mp.lab05.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Dvd;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.model.plataform.Plataform;
import uo.mp.lab05.dome.service.MediaLibrary;

public class GetNumberOfItemsOwnedTest {
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
     * Given: a mediaLibrary with two items, both in possession
     * When: the method is called
     * Then: return 2
     */
    @Test
    public void twoItemInPossession() {

	assertEquals(2, ml.getNumberOfItemsOwned());
    }

    /**
     * Given: a medialibary with one item in possesion
     * When: se llama al metodo
     * then: retorna 1
     */
    @Test
    public void oneItemInPossession() {
	cd1.setOwn(false);
	assertEquals(1, ml.getNumberOfItemsOwned());
    }

    /**
     * Given: una colecion vacia
     * When: se invoca al metodo
     * Then: retorna 0
     */
    @Test
    public void noItems() {
	MediaLibrary ml1 = new MediaLibrary();
	assertEquals(0, ml1.getNumberOfItemsOwned());
    }

    /**
     * Given: una coleccion con items y no eres el propietario
     * When: se invoca al metodo
     * Then: retorna 0
     */
    @Test
    public void notOwnItems() {
	cd1.setOwn(false);
	vg.setOwn(false);
	assertEquals(0, ml.getNumberOfItemsOwned());

    }
}
