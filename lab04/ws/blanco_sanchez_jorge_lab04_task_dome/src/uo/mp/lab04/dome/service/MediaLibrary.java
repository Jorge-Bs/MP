package uo.mp.lab04.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab04.dome.model.Item;

public class MediaLibrary {
    private ArrayList<Item> items = new ArrayList<Item>();

    /**
     * AÃ±ade elementos a la coleccion
     * 
     * @param item, elemento a añadir
     */
    public void add(Item item) {
	ArgumentChecks.isTrue(item != null, "invalid item");
	items.add(item);
    }

    /**
     * devuelve la cantidad de items que tienes en posesion
     * 
     * @return value cantidad de elementos en posesion
     */
    public int getNumberOfItemsOwned() {
	int value = 0;
	for (Item it : items) {
	    if (it.getOwn()) {
		value++;
	    }
	}
	return value;
    }

    /**
     * Lista todos los objetos que hay dentro del arrayList
     * 
     * @param out de tipo printStream
     * @return listado de objetos
     */
    public void list(PrintStream out) {
	ArgumentChecks.isTrue(out != null);
	out.println("List value");
	for (Item it : items) {
	    it.print(out);
	}
    }

    /**
     * Devuelve un arrayList con los items para los test
     * 
     * @return items lits
     */
    public List<Item> getItemsForTesting() {
	return new ArrayList<Item>(items);
    }

    /**
     * Busca el item dado como parametro y devuelve el item si lo encuentra, null en otro caso
     * 
     * @param theItem item a buscar
     * @return item encontrado o null
     */
    public Item searchItem(Item theItem) {
	ArgumentChecks.isTrue(theItem != null, "Objeto Invalido");
	for (Item itm : items) {
	    if (itm.equals(theItem)) {
		return itm;
	    }
	}
	return null;
    }

    /**
     * Devuelve una String con todos los autores de los items
     * 
     * @return String de los autores
     */
    public String getResponsables() {
	StringBuilder sb = new StringBuilder();
	sb.append("Responsables: ");
	if (items.size() == 0 || items == null) {
	    sb.append("No responsables found");
	} else {
	    for (int i = 0; i < items.size() - 1; i++) {
		sb.append(items.get(i)
		    .getResponsable() + ", ");
	    }
	    sb.append(items.get(items.size() - 1)
		.getResponsable());
	}
	return sb.toString();
    }

    /**
     * devuelve la suma de todos los precio de la coleccion
     * 
     * @return price
     */
    public double getTotalPrice() {
	double price = 0;
	for (Item itm : items) {
	    price += itm.getFinalPrice();
	}
	return price;
    }

    public String generateCodes() {
	StringBuilder sb = new StringBuilder();
	sb.append("Código Generado por los Items: \n");
	if (items == null || items.size() == 0) {
	    sb.append("");
	} else {
	    for (int i = 0; i < items.size() - 1; i++) {
		sb.append(items.get(i)
		    .code(i) + "-");
	    }
	    int index = items.size() - 1;
	    sb.append(items.get(index)
		.code(index));
	}
	return sb.toString();
    }
}
