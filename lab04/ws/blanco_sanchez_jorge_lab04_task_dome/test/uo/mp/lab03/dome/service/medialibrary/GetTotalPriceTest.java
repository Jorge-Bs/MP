package uo.mp.lab03.dome.service.medialibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.dome.model.Cd;
import uo.mp.lab04.dome.model.Dvd;
import uo.mp.lab04.dome.model.Videogame;
import uo.mp.lab04.dome.model.plataform.Plataform;
import uo.mp.lab04.dome.service.MediaLibrary;

public class GetTotalPriceTest {

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

    }

    /**
     * Given: una coleccion con un unico cd
     * When: se invoca al metodo
     * Then: devuelve el precio
     */
    @Test
    public void cdPrice() {
	ml.add(cd1);
	double price = Cd.PRICE + Cd.TAX;
	assertEquals(price, ml.getTotalPrice());
    }

    /**
     * Given: una coleccion con un unico dvd
     * When: se invoca al metodo
     * Then: devuelve el precio
     */
    @Test
    public void dvdPrice() {
	ml.add(dvd1);
	double price = Dvd.PRICE + Dvd.TAX;
	assertEquals(price, ml.getTotalPrice());
    }

    /**
     * Given: una coleccion con un unico videogame
     * When: se invoca al metodo
     * Then: devuelve el precio
     */
    @Test
    public void videogamePrice() {
	ml.add(vg);
	double price = Videogame.PRICE * Videogame.TAX;
	assertEquals(price, ml.getTotalPrice());
    }

    /**
     * Given: una coleccion con varios elementos
     * When: se invoca al metodo
     * Then: devuelve el precio total
     */
    @Test
    public void allItemsPrice() {
	ml.add(cd1);
	ml.add(dvd1);
	ml.add(vg);
	double price = Cd.PRICE + Cd.TAX + Dvd.PRICE + Dvd.TAX + Videogame.PRICE * Videogame.TAX;
	assertEquals(price, ml.getTotalPrice());
    }

    /**
     * Given: una coleccion vacia
     * When: se invoca al metodo
     * Then: devuelve el precio total
     */
    @Test
    public void nullItems() {
	assertEquals(0, ml.getTotalPrice());
    }

}
