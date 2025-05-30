package uo.mp2223.newsstand.ui;

import uo.mp.util.console.Console;
import uo.mp2223.newsstand.domain.Frequency;
import uo.mp2223.newsstand.domain.Magazine;
import uo.mp2223.newsstand.domain.Newspaper;
import uo.mp2223.newsstand.domain.Publication;
import uo.mp2223.newsstand.service.NewsstandException;


/**
 * Asks the user all the data for a new publication.
 * 
 */
public class PublicationForm {

	public static final int MAX_VALUE = 50;
	public static final int MIN_VALUE = 0;

	/**
	 * @return The new Publication object created. It will be be of any 
	 * of the child types of Publication.
	 * @throws NewsstandException 
	 */
	public Publication askForPublication() throws NewsstandException {
		String type = Console.readString("Type of publication? (n | m)");
		type = type.toLowerCase();
		switch (type) {
			case "n": return askForNewsPaper();
			case "m": return askForMagazine();
			default:  throw new NewsstandException("Valor del argumento invalido, vuleva a intertarlo");
		}

	}

	private Publication askForMagazine() throws NewsstandException {
		String name = Console.readString("name?");
		int stock = Console.readInt("stock?");
		int sales = Console.readInt("sales?");
		Frequency frequency = Frequency.valueOf(Console.readString("frequency?"));
		checkValues(name,stock,sales);
		
		return new Magazine(name, stock, sales, frequency);
	}

	private Publication askForNewsPaper() throws NewsstandException {
		String name = Console.readString("name?");
		int stock = Console.readInt("stock?");
		int sales = Console.readInt("sales?");
		checkValues(name,stock,sales);
		
		return new Newspaper(name, stock, sales);
	}
	
	private void checkValues(String value1,int value2, int value3) throws NewsstandException {
		if(value1.isBlank() || value1.isEmpty() ||
			value2<=MIN_VALUE || value2>MAX_VALUE ||
			value3<=MIN_VALUE || value3>MAX_VALUE) {
			throw new NewsstandException("Valores de los argumentos invalidos");
		}
	}

}
