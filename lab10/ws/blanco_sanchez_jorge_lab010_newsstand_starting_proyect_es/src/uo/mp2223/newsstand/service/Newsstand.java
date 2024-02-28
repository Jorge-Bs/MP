package uo.mp2223.newsstand.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import uo.mp2223.newsstand.domain.Order;
import uo.mp2223.newsstand.domain.Publication;
import uo.mp2223.newsstand.service.parsers.PublicationParser;
import uo.mp2223.newsstand.service.serializers.OrderSerializer;
import uo.mp2223.newsstand.service.serializers.PublicationSerializer;
import uo.mp2223.newsstand.service.sort.ByQuantityAndName;
import uo.mp2223.newsstand.service.sort.BySalesSorter;
import uo.mp2223.util.file.FileUtil;
import uo.mp2223.util.file.ZipFileUtil;
import uo.mp2223.util.log.Logger;

public class Newsstand {
	public static final int MIN_STOCK=10;

	private List<Publication> publications = new LinkedList<>();
	private List<Order> orders = new LinkedList<>();

	/**
	 * Loads all the products contained in the file into publications.
	 * None publication can be repeated regarding its name. If a publication
	 * is with a repeated name is already registered it will be ignored 
	 * and a message sent to log.
	 * 
	 * @param inFileName, the name of the file
	 * @throws NewsstandException, if the file name is invalid
	 * @throws FileNotFoundException 
	 */
	public void loadFile(String inFileName) throws NewsstandException, FileNotFoundException {
		List<String> lines = new FileUtil().readLines(inFileName);
		List<Publication> fileProducts = new PublicationParser().parse(lines);
		addPublications(fileProducts);
	}

	/**
	 * Add all the publications contained on the list passed as argument.
	 * None publication can be repeated regarding its name. If a publication
	 * is with a repeated name is already registered it will be ignored 
	 * and a message sent to log.
	 * 
	 * @param newProducts, the list with the new publications
	 * @throws NewsstandException 
	 */
	private void addPublications(List<Publication> newProducts) {
		for (Publication p : newProducts) {
			try{
				addPublication(p);
			}catch(NewsstandException e){
				Logger.log("Publicacion repetida");
			}
		}
	}

	/**
	 * Add the publication if it is name is not already registered
	 * @param p, the product to be added
	 * @throws NewsstandException if the product's name is repeated
	 */
	public void addPublication(Publication p) throws NewsstandException{
		try {
			checkInside(p);
			publications.add(p);
		}catch(NewsstandException e) {
			Logger.log("publicacion repetida");
		}
	}
	
	/**
	 * Lanza un error si la lista contine ese objeto
	 * @throws NewsstandException 
	 */
	private void checkInside(Publication p) throws NewsstandException {
		for(Publication pub: publications) {
			if(pub.equals(p)) {
				throw new NewsstandException(p.toString()+"ya esta en la coleccion");
			}
		}
	}

	/**
	 * Removes the product whose indicated by its name
	 * 
	 * @param name of the publication to be removed
	 * @throws NewsstandExceptionif the product does not exist
	 */
	public void removePublication(String name) {
		try {
			int pos = searchByName(name);
			publications.remove(pos);
		}catch(NewsstandException e) {
			Logger.log(e.getMessage());
		}
	}

	private int searchByName(String name) throws NewsstandException {
		for (int i = 0; i < publications.size(); i++) {
			Publication p = publications.get(i);
			if ((p.getName().equals(name)) /* compare both names */ )
				return i;
		}
		throw new NewsstandException("No hay disponible ningun objeto con ese nombre, vuelva a intertarlo.");
	}

	/**
	 * @return a list which a copy of the internal list of publications
	 * @throws NewsstandException 
	 */
	public List<Publication> getPublications() throws NewsstandException {
		List<Publication> copy = new ArrayList<>();
		checkLenght(publications);
		for(Publication pub:publications) {
			copy.add(pub.clone());
		}
		return copy;
	}
	
	/**
	 * Cmprueba la longitud de la lista
	 * Si esta vacia lanza una excepcion
	 * @throws NewsstandException 
	 */
	private void checkLenght(List<Publication> publications2) throws NewsstandException {
		if(publications2.isEmpty()) {
			throw new NewsstandException("No hay ninguna publicacion disponible");
		}
	}

	/**
	 * Generates a list of orders. One for every product with stock under limits
	 */
	public void createOrders() {
		orders.clear();
		for(Publication pub:publications) {
			if(pub.getStock()<MIN_STOCK) {
				orders.add(pub.generateOrders());
			}
		}
	}

	/**
	 * @return a list which a copy of the internal list of orders
	 */
	public List<Order> getOrders() {
		// Returns a list, copy of our own list to not break the encapsulation
		// A copy constructor needed in our lists
		List<Order> copy = new ArrayList<>();
		for(Order order:orders) {
			copy.add(order.clone());
		}
		return copy;
	}

	/**
	 * Save all orders to a file with the given format
	 * 
	 * @param fileName
	 * @throws IOException 
	 * @throws NewsstandException in case
	 * 		- the file name is invalid
	 */
	public void saveOrdersToFile(String fileName) throws IOException {
		OrderSerializer serializer = new OrderSerializer();
		List<String> lines = serializer.serialize(orders);
		new FileUtil().writeLines(fileName, lines);
	}

	/**
	 * Imports all the publications from the zip file and removes all the 
	 * previous ones.
	 * 
	 * @param fileName
	 * @throws NewsstandException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void importPublicationsFromZipFile(String fileName) throws FileNotFoundException, IOException, NewsstandException {
		List<String> lines = new ZipFileUtil().readLines(fileName);
		List<Publication> publications = new PublicationParser().parse(lines);
		addPublications(publications);
	}

	/**
	 * Saves all the publications to a zip file. The file produced can be read
	 * by the method @see importPublicationsFromZipFile
	 * 
	 * @param fileName
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void exportPublicationsToZipFile(String fileName) throws FileNotFoundException, IOException {
		PublicationSerializer serializer = new PublicationSerializer();
		List<String> lines = serializer.serialize(publications);
		new ZipFileUtil().writeLines(fileName, lines);
	}
	//Buscar algoritmo de ordenacion en burbuja
	public void sortByName() {
		Collections.sort(publications);
		
	}
	
	public void sortBySales() {
		Collections.sort(publications, new BySalesSorter());
	}
	
	public void sortOrderByQuantityAndName() {
		Collections.sort(orders, new ByQuantityAndName());
	}
}
