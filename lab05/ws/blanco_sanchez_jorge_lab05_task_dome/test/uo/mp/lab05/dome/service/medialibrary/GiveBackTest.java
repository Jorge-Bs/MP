package uo.mp.lab05.dome.service.medialibrary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Item;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.model.plataform.Plataform;
import uo.mp.lab05.dome.service.MediaLibrary;

public class GiveBackTest {

    private Item book;
    private Item cd;
    private MediaLibrary ml;
    private Videogame vg;

    @BeforeEach
    public void setUp() {
	cd = new Cd("Alchemy", "Dire Straits", 12, 75);
	book = new Book("boo1k", "13-133-453-8b", "ediBooks", "userEditor");
	vg = new Videogame("Horizon Forbidden West", "Mathijs de Jonge", 1, Plataform.PLAYSTATION);
	vg.setOwn(true);
	book.setOwn(true);
	cd.setOwn(true);
	ml = new MediaLibrary();
	ml.add(book);
	ml.add(cd);
	ml.add(vg);
	ml.borrow(book);
    }

    /**
     * Given: una coleccion con tres objetos, 2 de ellos son de tipo Borrowable
     * When: se devuelve un item
     * Then: El objeto tiene el estado de disponible
     */
    @Test
    public void giveBackItem() {
	Book book1 = (Book) book;
	assertFalse(book1.isAvailable());
	assertEquals(book, ml.giveBack(book));
	assertTrue(book1.isAvailable());
    }

    /**
     * Given: una coleccion con tres objetos, 2 de ellos son de tipo Borrowable
     * When: se devuelve un item que no estaba siendo prestado
     * Then: El objeto no modifica su estado y el metodo devuelve null
     */
    @Test
    public void giveBackItemNonBorrowed() {
	Cd cd1 = (Cd) cd;
	assertTrue(cd1.isAvailable());
	assertNull(ml.giveBack(cd));
	assertTrue(cd1.isAvailable());
    }

    /**
     * Gieven: una coleccion con tres objetos
     * When: se devuelve null
     * Then: salta IllegalArgumentException
     */
    @Test
    public void giveBackNull() {
	try {
	    ml.giveBack(null);
	    fail("Debería haber fallado");
	} catch (IllegalArgumentException e) {
	    assertEquals("El item no puede ser null", e.getMessage());
	}
    }

    /**
     * given: una coleccion con tres items
     * When: se devuelve un item que no es de tipo borrowable
     * Then: devuelve null
     */
    @Test
    public void giveBackANonBorrowableItem() {
	assertNull(ml.giveBack(vg));
    }

    /**
     * Given: una coleccion con tres items
     * When: se devuevel un objeto, misma informacion, diferente referencia
     * Then: el objeto de la coleccion pasa a estar disponible
     */
    @Test
    public void giveBackSameInformationItem() {
	Book book1 = (Book) book;
	Item book2 = new Book("boo1k", "13-133-453-8b", "ediBooks", "userEditor");
	assertFalse(book1.isAvailable());
	assertEquals(book, ml.giveBack(book2));
	assertTrue(book1.isAvailable());
    }

}
