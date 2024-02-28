package uo.mp2223.newsstand.service.parsers;

import java.util.ArrayList;
import java.util.List;

import uo.mp2223.newsstand.domain.Frequency;
import uo.mp2223.newsstand.domain.Magazine;
import uo.mp2223.newsstand.domain.Newspaper;
import uo.mp2223.newsstand.domain.Publication;
import uo.mp2223.util.log.Logger;


public class PublicationParser {
	public static final int LENGHT_MAGAZINE_STRING=5;
	public static final int LENGHT_NEWSPAPER_STRING=4;
	
	private int lineNumber;

	/**
	 * Transforms a list of Strings in a list of instances of Publication.
	 * Any of the following are invalid lines in the input file: 
	 * 		- blank lines, 
	 * 		- wrong number of fields in a line, and 
	 * 		- incorrect data format in numeric fields.
	 * Invalid lines will not produce a Publication instance but will throw an InvalidLineFormatException instead.
	 * As a result of processing this exception, a message will be written to a log (use Log) 
	 * @param lines non-null list of strings, probably empty
	 * 		One by each publication
	 * 				type_of_publication \t name_of_publication \t sales \t stock \t frequency
	 * 
	 * @return a list of publications
	 */
	public List<Publication> parse(List<String> lines) {
		lineNumber=0;
		List<Publication> list = new ArrayList<>();
		for(String line:lines) {
			lineNumber++;
			try {
				checkIsBlank(line);
				Publication pub = parseLine(line);
				list.add(pub);
			}catch(InvalidLineFormatException e) {
				Logger.log(e.getMessage());
			}
		}
		return list;
	}
	
	/**
	 * Transforma el contenido de los archivos  a objetos de tipo Publication
	 * @param line
	 * @return Publication objet
	 * @throws InvalidLineFormatException 
	 */
	private Publication parseLine(String line) throws InvalidLineFormatException {
		String[] tokens = line.split("\t");
		if(tokens[0].equals("magazine")) {
			return parseMagazine(tokens);
		}else if(tokens[0].equals("newspaper")) {
			return parseNewspaper(tokens); 
		}else {
			throw new InvalidLineFormatException(lineNumber, "Publicacion desconocida");
		}
	}
	
	/**
	 * Si el objeto es de tipo  newspaper, se crea la publicacion
	 * @param tokens del newpaper
	 * @return publication objet
	 * @throws InvalidLineFormatException 
	 */
	private Publication parseNewspaper(String[] tokens) throws InvalidLineFormatException {
		checkTokens(tokens,LENGHT_NEWSPAPER_STRING);
		return new Newspaper(tokens[1],getInteger(tokens[2]),
				getInteger(tokens[3]));
	}

	/**
	 * Si el objeto es de tipo  magazine, se crea la publicacion
	 * @param tokens del magazine
	 * @return publication objet
	 * @throws InvalidLineFormatException 
	 */
	private Publication parseMagazine(String[] tokens) throws InvalidLineFormatException {
		checkTokens(tokens,LENGHT_MAGAZINE_STRING);
		return new Magazine(tokens[1],getInteger(tokens[2]),
				getInteger(tokens[3]),getFrecuency(tokens[4]));
	}
	
	/**
	 * Comprueba que la linea no tenga
	 * @throws InvalidLineFormatException 
	 * 
	 */
	private void checkTokens(String[] tokens, int amount) throws InvalidLineFormatException {
		if(tokens.length!=amount) {
			throw new InvalidLineFormatException(lineNumber,"numero de campos invalidos");
		}
	}
	/**
	 * Parsea el valor string a int
	 * @param value
	 * @return int value
	 */
	private int getInteger(String value) throws InvalidLineFormatException{
			try {
				return Integer.parseInt(value);
			}catch(Exception e) {
				throw new InvalidLineFormatException(lineNumber,"parametros numericos incorrectos");
			}
	}
	
	/**
	 * Parsea la frecuencia de entrega
	 * @param id
	 * @return Frequency enumeration type
	 */
	private Frequency getFrecuency(String id) {
		switch(id) {
		case "QUARTERLY":
			return Frequency.QUARTERLY;
		case "MONTHLY":
			return Frequency.MONTHLY;
		case "BIMONTHLY":
			return Frequency.BIMONTHLY;
		case "DAILY":
			return Frequency.DAILY;
		case "WEEKLY":
			return Frequency.WEEKLY;
		default:
			return null;
		}
	}
	
	/**
	 * Comprueba que la linea no este en blanco, si lo  es lanza un error
	 * @param line, linea a comprobar
	 * @throws InvalidLineFormatException
	 */
	private void checkIsBlank(String line) throws InvalidLineFormatException{
		if(line.isBlank()) {
			throw new InvalidLineFormatException(lineNumber,"linea en blanco");
		}
	}
}
