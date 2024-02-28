package uo.mp.newsstand.service.newsstand;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp2223.newsstand.domain.Frequency;
import uo.mp2223.newsstand.domain.Magazine;
import uo.mp2223.newsstand.domain.Newspaper;
import uo.mp2223.newsstand.service.Newsstand;
import uo.mp2223.newsstand.service.NewsstandException;

public class LoadFileTest {
	
	private Newsstand ns;

	/*
	 * Nombre invalido
	 * Publicaciones correctas
	 * Publicaciones de tipo desconocidas
	 * Publicacinoes con valores numericos incorrectos
	 * Publicaciones con distinstos campos
	 * 
	 */
	
	@BeforeEach
	public void setUp() {
		ns = new Newsstand();
	}
	
	/**
	 * Given: un nombre de longitud inferior a 5
	 * When: se intenta leer un archivo
	 * Then: se lanza un error
	 * @throws FileNotFoundException
	 */
	@Test
	public void invalidName() throws FileNotFoundException {
		try {
			ns.loadFile("ab");
		}catch(NewsstandException e) {
			assertEquals("Nombre invalido",e.getMessage());
		}
	}
	
	/**
	 * Given: un archivo con publicaciones correctas
	 * When: se invoca al metodo
	 * Then: se procesan las lineas
	 * @throws FileNotFoundException 
	 * @throws NewsstandException 
	 */
	@Test
	public void correctFile() throws FileNotFoundException, NewsstandException {
		ns.loadFile("correctPub.txt");
		assertEquals(4,ns.getPublications().size());
		
		Newspaper n = new Newspaper("La Nueva España", 14, 30);
		Newspaper n1 = new Newspaper("El Mundo", 4, 10);
		Magazine m = new Magazine("Hola", 14, 30, Frequency.MONTHLY);
		Magazine m1 = new Magazine("PCWord", 14, 30, Frequency.QUARTERLY);
		
		assertTrue(ns.getPublications().contains(n));
		assertTrue(ns.getPublications().contains(n1));
		assertTrue(ns.getPublications().contains(m));
		assertTrue(ns.getPublications().contains(m1));
	}
	
	/**
	 * Gieven: un archivo con publicacione correctas e incorrectas
	 * When: se invoca al metodo
	 * Then: se procesan las lineas
	 * @throws FileNotFoundException 
	 * @throws NewsstandException 
	 */
	@Test
	public void unknownType() throws FileNotFoundException, NewsstandException {
		ns.loadFile("publicationsUnknownType.txt");
		assertEquals(1,ns.getPublications().size());
		
		Newspaper n = new Newspaper("La Nueva España", 14, 30);
		assertTrue(ns.getPublications().contains(n));
	}
	
	/**
	 * Given: un archivo con publicacione correctas e incorrectas y lineas en blanco
	 * When: se invoca al metodo
	 * Then: se procesan las lineas
	 * @throws FileNotFoundException 
	 * @throws NewsstandException 
	 */
	@Test
	public void emptyLines() throws FileNotFoundException, NewsstandException {
		ns.loadFile("publicationsWithEmptyLines.txt");
		assertEquals(2,ns.getPublications().size());
		
		Newspaper n = new Newspaper("La Nueva España", 14, 30);
		Newspaper n1 = new Newspaper("El Mundo", 4, 10);
		
		assertTrue(ns.getPublications().contains(n));
		assertTrue(ns.getPublications().contains(n1));
	}
	
	/**
	 * Give: parametro null
	 * when: se invoca al metodo
	 * Then: se produce un IllegalArgumentException
	 * @throws NewsstandException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void nullParam() throws FileNotFoundException, NewsstandException {
		try {
			ns.loadFile(null);
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Given: un archivo con el nombre en blanco
	 * when: se invoca al metodo
	 * Then: se produce un IllegalArgumentException
	 * @throws NewsstandException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void blankNameFile() throws FileNotFoundException, NewsstandException {
		try {
			ns.loadFile("   ");
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Given: un fichero vacio
	 * When: se invoca al metodo
	 * Then: la lista esta vacia
	 * @throws FileNotFoundException 
	 * @throws NewsstandException 
	 */
	@Test
	public void emptyFile() throws FileNotFoundException, NewsstandException{
		ns.loadFile("empty.txt");
		try {
			assertEquals(0,ns.getPublications().size());
		}catch(NewsstandException e) {
			assertEquals(e.getMessage(),"No hay ninguna publicacion disponible");
		}
	}
	
}
