package uo.mp2223.newsstand.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import uo.mp.util.console.Console;
import uo.mp2223.newsstand.domain.Publication;
import uo.mp2223.newsstand.service.Newsstand;
import uo.mp2223.newsstand.service.NewsstandException;
import uo.mp2223.util.log.Logger;


/**
 * It is in charge of interacting with the user:
 * 	- Shows the menu of options
 *  - Process the option chosen by the user
 *  	- For that it asks the user the necessary data to fulfill the request
 *  	- Shows the result of the request
 *  - In case of error shows an explaining message
 *  
 *  Note: This is the unique class allowed to show information to the user
 */
public class UserInterface {
	private static final int EXIT = 0;

	private Menu menu = new Menu();
	private Newsstand newsStand = new Newsstand();
	
	public void show() {
		int option = EXIT;
		do {
			menu.show();
			option = menu.readOption();
			try {
				processOption(option);
			}catch(NewsstandException  | FileNotFoundException e) {
				handleUserError(e);
			}catch(RuntimeException | IOException e) {
				handleSystemError(e);
				break;
			}
			
		} while (option != EXIT);
	}

	
	private void handleSystemError(Exception e) {
		Logger.log("Uncatched exception ");
		System.err.println("Error irrecuperable: "+e.getMessage());
	}
	
	
	private void handleUserError(Exception e) {
		System.err.println("Error recuperable: "+ e.getMessage());
	}
	
	private void processOption(int option) throws NewsstandException, IOException {
		switch( option ) {
			case EXIT: return;
			case 1: loadFile(); break;
			case 2: showPublications(); break;				
			case 3: addPublication(); break;
			case 4: removePublication(); break;				
			case 5: createOrders(); break; 				
			case 6: saveOrdersToFile(); break;
			case 7: importFromZip(); break;
			case 8: exportToZip(); break;
			case 9: sortByName(); break;
			case 10: sortBySales(); break;
			case 11: sortOrderByQuantityAndName(); break;
		}
	}

	private void loadFile() throws FileNotFoundException {
		try {
			String fileName = Console.readString("File name?");
			newsStand.loadFile( fileName );
		}catch(NewsstandException e) {
			Logger.log(e.getMessage());
		}
	}
	
	private void addPublication() {
			try {
				Publication p = new PublicationForm().askForPublication();
				newsStand.addPublication( p );
			}catch(NewsstandException e) {
				Logger.log(e.getMessage());
			}
	}

	private void removePublication() {
		String name = Console.readString("publication name?");
		newsStand.removePublication( name );
	}
	
	private void showPublications() {
		try {
			List<Publication> publications = newsStand.getPublications();
			listPublications( publications );
		}catch(NewsstandException e) {
			Logger.log(e.getMessage());
		}
	}

	private void createOrders() {
		newsStand.createOrders();
	}

	private void listPublications(List<Publication> publications) {
		Console.println("\nList of publications");
		Console.println("------------------");
		for (Publication p: publications) {
			System.out.println( p );
		} 
	
		Console.println("------------------");
   }	
	
	private void saveOrdersToFile() throws IOException {
		String fileName = Console.readString("output file name?");
		newsStand.saveOrdersToFile( fileName );
	}
	
	private void importFromZip() throws FileNotFoundException, IOException, NewsstandException {
		String fileName = Console.readString("input zip file name?");
		newsStand.importPublicationsFromZipFile( fileName );
	}
	
	private void exportToZip() throws FileNotFoundException, IOException {
		String fileName = Console.readString("output file name?");
		newsStand.exportPublicationsToZipFile( fileName );
	}
	
	
	private void sortByName() {
		newsStand.sortByName();
	}
	
	private void sortBySales() {
		newsStand.sortBySales();
	}

	private void sortOrderByQuantityAndName() {
		newsStand.sortOrderByQuantityAndName();
	}
}
