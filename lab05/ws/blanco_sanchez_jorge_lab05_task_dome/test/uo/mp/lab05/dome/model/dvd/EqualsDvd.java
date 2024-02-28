package uo.mp.lab05.dome.model.dvd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Dvd;

public class EqualsDvd {

    /**
     * Given: dos objetos iguales
     * When: se invoca al metodo
     * Then: devuelve true
     */
    @Test
    public void equalDvd() {
	Dvd dvd1 = new Dvd("Star Wars", "George Lucas", 125);
	assertTrue(dvd1.equals(dvd1));
    }

    /**
     * Given: dos objetos con la misma informacion
     * When: se invoca al metodo
     * Then: devuelve true
     */
    @Test
    public void sameInformation() {
	Dvd dvd1 = new Dvd("Star Wars", "George Lucas", 125);
	Dvd dvd2 = new Dvd("Star Wars", "George Lucas", 125);
	assertTrue(dvd1.equals(dvd2));
    }

    /**
     * Given: un objeto
     * When: se invoca al metodo con null
     * Then: devuelve false
     */
    @Test
    public void nullItem() {
	Dvd dvd1 = new Dvd("Star Wars", "George Lucas", 125);
	assertFalse(dvd1.equals(null));
    }

}
