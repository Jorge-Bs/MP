package uo.mp.lab05.dome.model.cd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Cd;

public class EqualsTest {

    /**
     * Given: dos objetos iguales
     * When: se invoca al metodo
     * Then: devuelve true
     */
    @Test
    public void equalCd() {
	Cd cd1 = new Cd("Alchemy", "Dire Straits", 12, 75);
	assertTrue(cd1.equals(cd1));
    }

    /**
     * Given: dos objetos con la misma informacion
     * When: se invoca al metodo
     * Then: devuelve true
     */
    @Test
    public void sameInformation() {
	Cd cd1 = new Cd("Alchemy", "Dire Straits", 12, 75);
	Cd cd2 = new Cd("Alchemy", "Dire Straits", 12, 75);
	assertTrue(cd1.equals(cd2));
    }

    /**
     * Given: un objeto
     * When: se invoca al metodo con null
     * Then: devuelve false
     */
    @Test
    public void nullItem() {
	Cd cd1 = new Cd("Alchemy", "Dire Straits", 12, 75);
	assertFalse(cd1.equals(null));
    }

}
