package uo.mp.lab05.dome.service.medialibrary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Item;
import uo.mp.lab05.dome.model.Videogame;
import uo.mp.lab05.dome.model.plataform.Plataform;
import uo.mp.lab05.dome.service.MediaLibrary;

public class BorrowTest {

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
	ml = new MediaLibrary();
	ml.add(book);
	ml.add(cd);
    }

    /**
     * Given: un dome con dos elemetos
     * When: se presta el libro
     * Then: el estado de disponible del libro se pasa a false
     */
    @Test
    public void borrowBook() {
	assertEquals(book, ml.borrow(book));
	Book book1 = (Book) book;
	assertFalse(book1.isAvailable());
    }

    /**
     * Given: un dome con elementos
     * When: se intenta prestar null
     * Then: IllegalArgumentException es lanzada
     */
    @Test
    public void nullBorrow() {
	try {
	    ml.borrow(null);
	    fail("deberia haber fallado");
	} catch (IllegalArgumentException e) {
	    assertEquals("Item invalido", e.getMessage());
	}
    }

    /**
     * Given: un dome con dos elemetos
     * When: se intenta prestar el cd
     * Then: este objeto no se puede prestar, ya que no está en propiedad
     */
    @Test
    public void noBorrowableItem() {
	Cd cd1 = (Cd) cd;
	assertFalse(cd1.isAvailable());
	assertNull(ml.borrow(cd));
	assertFalse(cd1.isAvailable());

    }

    /**
     * Given: un dome con tres elemetos
     * When: se intenta prestar un videojuego,
     * Then: este item no se puede prestar, devuelve null
     */
    @Test
    public void borrowAnonBorrowableItem() {
	assertNull(ml.borrow(vg));
    }

    /**
     * Given: un dome con tres elementos
     * When: se presta un objeto con la misma informacion
     * Then: el item pasa a prestado
     */
    @Test
    public void borrowSameInformationObjet() {
	Item book1 = new Book("boo1k", "13-133-453-8b", "ediBooks", "userEditor");
	assertNotNull(ml.borrow(book1));
    }
}
