package uo.mp.newsstand.service.parsers.publicationparser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp2223.newsstand.domain.Newspaper;
import uo.mp2223.newsstand.domain.Publication;
import uo.mp2223.newsstand.service.parsers.PublicationParser;

public class ParseTest {
	
	private List<String> file;
	private PublicationParser ps;
	private List<Publication> result;
	private String one;
	
	//Caso 1- el archivo contiene un periodico correcto
	//Caso 2- el archivo contiene dos periodicos iguales, al ser el parser, los transforma a objetos
	//Caso 3- el archivo contiene un peridico con mas campos
	//Caso 4- el archivo contiene un periodico con menos campos
	//Caso 5- el archivo contiene un tipo de publicacion incorrecta
	//caso 6- el archivo contiene un periodico y una linea en blanco

	@BeforeEach
	public void setUp() throws Exception {
		file= new ArrayList<>();
		ps = new PublicationParser();
		result = new ArrayList<>();
		one = "newspaper	La Nueva España	14	30";
	}

	
	/**
	 * Given: un archivo con un periodico correcto
	 * When: se invoca al metodo para cargar un archivo de publicaciones
	 * Then: se carga correctamente el archivo
	 */
	@Test
	public void validNewspaper() {
		Publication p1 = new Newspaper("La Nueva España", 14, 30);
		file.add(one);
		result = ps.parse(file);
		assertEquals(1,result.size());
		assertTrue(result.get(0).equals(p1));
	}
	
	/**
	 * Given: un archivo dos un periodico correctos, pero uno de ellos contiene el mismo nombre que el anterior
	 * When: se invoca al metodo para cargar un archivo de publicaciones
	 * Then: se transforman ambos archivos a publicaciones
	 */
	@Test
	public void sameNamesNewspaper() {
		Publication p1 = new Newspaper("La Nueva España", 14, 30);
		String two = "newspaper	La Nueva España	14	30";
		file.add(one);
		file.add(two);
		result = ps.parse(file);
		assertEquals(2,result.size());
		assertTrue(result.get(0).equals(p1));
		assertTrue(result.get(1).equals(p1));
	}

	/**
	 * Given: un archivo con un periodico con mas campos
	 * When: se invoca al metodo para cargar un archivo de publicaciones
	 * Then: se produce un error que será manejado por el metodo y retorna una lista vacia
	 */
	@Test
	public void invalidFildsMoreThanExpected() {
		String invalid = "newspaper	La Nueva España	14	30 25";
		file.add(invalid);
		result = ps.parse(file);
		assertEquals(0,result.size());
	}
	
	/**
	 * Given: un archivo con un periodico con menos campos
	 * When: se invoca al metodo para cargar un archivo de publicaciones
	 * Then: se produce un error que será manejado por el metodo y retorna una lista vacia
	 */
	@Test
	public void invalidFildsLessThanExpected() {
		String invalid = "newspaper	La Nueva España	14";
		file.add(invalid);
		result = ps.parse(file);
		assertEquals(0,result.size());
	}
	
	/**
	 * Given: un archivo con una publicacion desconocida
	 * When: se invoca al metodo para cargar un archivo de publicaciones
	 * Then: se produce un error que será manejado por el metodo y retorna una lista vacia
	 */
	@Test
	public void invalidPublication() {
		String invalid = "news	La Nueva España	14";
		file.add(invalid);
		result = ps.parse(file);
		assertEquals(0,result.size());
	}
	
	/**
	 * Given: un archivo con un periodico y una linea en blanco
	 * When: se invoca al metodo para cargar un archivo de publicaciones
	 * Then: se produce un error, al procesar la linea en blanco,la cual será manejado por el método 
	 * 		y se creará una lista con una unica publicacion, ya que el periodico es correcto
	 */
	@Test
	public void invalidLine() {
		Publication p1 = new Newspaper("La Nueva España", 14, 30);
		String invalid = " ";
		file.add(invalid);
		file.add(one);
		result = ps.parse(file);
		assertEquals(1,result.size());
		assertTrue(result.get(0).equals(p1));
	}
}
