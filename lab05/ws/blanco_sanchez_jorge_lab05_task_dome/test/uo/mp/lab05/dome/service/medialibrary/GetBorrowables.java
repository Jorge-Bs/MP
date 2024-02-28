package uo.mp.lab05.dome.service.medialibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Dvd;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.model.plataform.Plataform;
import uo.mp.lab05.dome.service.MediaLibrary;

public class GetBorrowables {
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
     * Given: una coleccion con tres items donde dos de ello se pueden prestar
     * when: se invoca al metodo
     * Then: se imprime el toString de los objetos
     */
    @Test
    public void twoItemsAvailable() {
	StringBuilder sb = new StringBuilder();
	sb.append("Items que estan disponibles para ser prestados\n");
	sb.append("----------------------------------------------\n");
	sb.append(cd1);
	String esperado = "Items que estan disponibles para ser prestados\n"
		+ "----------------------------------------------\n" + cd1.toString() + "\n";
	String resultante = ml.getAvailables();

	assertEquals(esperado, resultante);

    }

}
