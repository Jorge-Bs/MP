package uo.mp.newsstand.service.newsstand;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import uo.mp2223.newsstand.domain.Frequency;
import uo.mp2223.newsstand.domain.Magazine;
import uo.mp2223.newsstand.domain.Newspaper;
import uo.mp2223.newsstand.service.Newsstand;
import uo.mp2223.newsstand.service.NewsstandException;

public class importPublicationsFromZipFile {

	
	/**
	 * Given: un archivo con publicaciones validas, pulbicaciones desconocidas, publicaciones con campos invalidos
	 * y lineas en blancos
	 * When: se invoca al metodo
	 * Then: se crea una lista con los objetos, la lista solo contiene dos publicaciones correctas
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws NewsstandException
	 */
	@Test
	public void zipToPublications() throws FileNotFoundException, IOException, NewsstandException {
		Newsstand ns = new Newsstand();
		ns.importPublicationsFromZipFile("pub.gz");
		assertEquals(2,ns.getPublications().size());
		
		Newspaper n = new Newspaper("El Mundo",4,10);
		Magazine m = new Magazine("Hola", 14, 30, Frequency.MONTHLY);
		
		assertTrue(ns.getPublications().contains(n));
		assertTrue(ns.getPublications().contains(m));
	}

	
	/**
	 * Given: un archivo con el parametro null de nombre
	 * When:se invoca al metodo
	 * Then: se produce un illegalArgumentException e
	 * @throws NewsstandException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void nullName() throws FileNotFoundException, IOException, NewsstandException {
		try {
			Newsstand ns = new Newsstand();
			ns.importPublicationsFromZipFile(null);
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Given: un archivo con el nombre en blanco
	 * when: se invoca al metodo
	 * Then: se produce un IllegalArgumentException
	 * @throws NewsstandException 
	 * @throws IOException 
	 */
	@Test
	public void blankNameFile() throws NewsstandException, IOException {
		try {
			Newsstand ns = new Newsstand();
			ns.importPublicationsFromZipFile("   ");
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Given: un nombre de longitud inferior a 5
	 * When: se intenta leer un archivo
	 * Then: se lanza un error
	 * @throws IOException 
	 */
	@Test
	public void invalidName() throws IOException {
		try {
			Newsstand ns = new Newsstand();
			ns.importPublicationsFromZipFile("abc");
		}catch(NewsstandException e) {
			assertEquals("Nombre invalido",e.getMessage());
		}
	}
}
