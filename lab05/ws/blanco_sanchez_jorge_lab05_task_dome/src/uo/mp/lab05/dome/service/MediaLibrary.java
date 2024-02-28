package uo.mp.lab05.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab05.dome.model.Borrowable;
import uo.mp.lab05.dome.model.Item;
import uo.mp.util.check.ArgumentChecks;

public class MediaLibrary {
    private List<Item> items = new ArrayList<Item>();
    private List<Borrowable> borrowable = new ArrayList<>();

    /**
     * Añade elementos a la coleccion
     * 
     * @param item, elemento a añadir
     */
    public void add(Item item) {
	ArgumentChecks.isTrue(item != null, "invalid item");
	items.add(item);
	if (item instanceof Borrowable) {
	    borrowable.add((Borrowable) item);
	}
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
     * 
     */
    public void list(PrintStream out) {
	ArgumentChecks.isTrue(out != null);
	out.println("List value");
	for (Item it : items) {
	    it.print(out);
	    out.append("\n");
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

    /**
     * Devuelve una String con los objetos que se puden prestar
     * 
     * @return string con objetos que se pueden prestar
     */
    public String getBorrowables() {
	StringBuilder sb = new StringBuilder();
	sb.append("Items que se pueden prestar\n");
	sb.append("---------------------------\n");
	for (Borrowable itm : borrowable) {
	    sb.append(itm + "\n");
	}
	return sb.toString();
    }

    /**
     * Devuelve una String con los objetos que se puden prestar y estan disponibles
     * 
     * @return string con objetos que estan disponibles
     */
    public String getAvailables() {
	StringBuilder sb = new StringBuilder();
	sb.append("Items que estan disponibles para ser prestados\n");
	sb.append("----------------------------------------------\n");
	for (Borrowable itm : borrowable) {
	    if (itm.isAvailable()) {
		sb.append(itm + "\n");
	    }
	}
	return sb.toString();
    }

    /**
     * Busca el item en la coleccion
     * 
     * @param item a buscar
     * 
     */
    private Borrowable searchBorrowableItem(Borrowable item) {
	for (Borrowable itm : borrowable) {
	    if (itm.equals(item)) {
		return itm;
	    }
	}
	return null;
    }

    /**
     * Presta un item dado como parametro
     * 
     * @param itm item a prestar
     * @return item que se ha prestado o null si no se ha encontrado itema a
     */
    public Borrowable borrow(Item itm) {
	ArgumentChecks.isTrue(itm != null, "Item invalido");
	if (itm instanceof Borrowable) {
	    Borrowable item = searchBorrowableItem((Borrowable) searchItem(itm));
	    if (item == null) {
		return null;
	    } else if (item.isAvailable()) {
		item.borrow();
		return item;
	    }
	}
	return null;
    }

    /**
     * Devuelve un item que está prestado
     */
    public Borrowable giveBack(Item itm) {
	ArgumentChecks.isTrue(itm != null, "El item no puede ser null");
	if (itm instanceof Borrowable) {
	    Borrowable item = searchBorrowableItem((Borrowable) searchItem(itm));
	    if (item == null) {
		return null;
	    } else if (item.isBorrow()) {
		item.giveBack();
		return item;
	    }
	}
	return null;
    }
}
