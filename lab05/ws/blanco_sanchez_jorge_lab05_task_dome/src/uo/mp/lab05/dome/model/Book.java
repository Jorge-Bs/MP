package uo.mp.lab05.dome.model;

import java.io.PrintStream;

import uo.mp.util.check.ArgumentChecks;

public class Book extends Item implements Borrowable {
    public static final int DEFAULT_PRICE = 30;
    public static final double TAX = 0.04;
    public static final boolean DEFAULT_AVAILABLE = true;
    public static final boolean DEFAULT_BORROW_STATUS = false;

    private String isbn;
    private String editorial;
    private String autor;

    private boolean available;
    private boolean borrow;

    /**
     * Constructor que recibe los siguintes parametros:
     * 
     * @param titulo
     * @param isbn
     * @param editorial
     * @param autor
     */
    public Book(String titulo, String isbn, String editorial, String autor) {
	super(titulo, DEFAULT_PRICE);
	setIsbn(isbn);
	setAutor(autor);
	setEditorial(editorial);
	setAvailable(DEFAULT_AVAILABLE);
    }

    /**
     * Devuelve el valor del isbn
     * 
     * @return isbn value
     */
    private String getIsbn() {
	return isbn;
    }

    /**
     * Devuelve la editorial
     * 
     * @return editorial
     */
    private String getEditorial() {
	return editorial;
    }

    /**
     * Devuelve el atuor
     * 
     * @return
     */
    private String getAutor() {
	return autor;
    }

    /**
     * Establece el isbn
     * 
     * @param isbn
     */
    private void setIsbn(String isbn) {
	ArgumentChecks.isTrue(isbn != null && !isbn.isBlank(), "Isbn invalido");
	this.isbn = isbn;
    }

    /**
     * Establece la editora
     * 
     * @param editorial
     */
    private void setEditorial(String editorial) {
	ArgumentChecks.isTrue(editorial != null && !editorial.isBlank(), "editorial invalido");
	this.editorial = editorial;
    }

    /**
     * Establece el autor
     * 
     * @param autor
     */
    private void setAutor(String autor) {
	ArgumentChecks.isTrue(autor != null && !autor.isBlank(), "autor invalido");
	this.autor = autor;
    }

    /**
     * Establece el estado de prestado en el item
     * 
     * @param availabe
     */
    private void setAvailable(boolean available) {
	this.available = available;
    }

    /**
     * Establece el estado de prestado del objeto
     * 
     * @param borrow
     */
    private void setBorrow(boolean borrow) {
	this.borrow = borrow;
    }

    /**
     * Imprime el estado del objeto
     */
    public void print(PrintStream out) {
	out.append(toString());
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Book Titulo: " + getTitle());
	builder.append("\nIsbn: " + getIsbn());
	builder.append("\nEditorial: " + getEditorial());
	builder.append("\nAutor: " + getAutor());
	builder.append("\nComentario: " + getComment());
	if (getOwn()) {
	    builder.append("\nYou own it\n");
	} else {
	    builder.append("\nYou do not own it\n");
	}
	return builder.toString();
    }

    /**
     * Devuelve el autor del CD
     * 
     * @return String autor
     */
    @Override
    public String getResponsable() {
	return getAutor();
    }

    /**
     * Devuelve el precio final del objeto
     * 
     * @return int price
     */
    public double getFinalPrice() {
	return getBasePrice() * TAX;
    }

    /**
     * Devuelve true si un item está disponibles para ser prestado
     * 
     * @return true si se puede prestar, false en caso contrario
     */
    @Override
    public boolean isAvailable() {
	return this.getOwn() && this.available;
    }

    /**
     * Presta el objeto, establece el estado en prestado
     */
    @Override
    public void borrow() {
	if (isAvailable()) {
	    setAvailable(!DEFAULT_AVAILABLE);
	    setBorrow(!DEFAULT_BORROW_STATUS);
	}
    }

    /**
     * Devuelve el objeto, establece el estado en no prestado
     */
    @Override
    public void giveBack() {
	if (isBorrow()) {
	    setAvailable(DEFAULT_AVAILABLE);
	    setBorrow(DEFAULT_BORROW_STATUS);
	}
    }

    /**
     * Devuelve true si el objeto está prestado
     * 
     * @return borrow , true si el objeto está prestado, false en caso contrario
     */
    public boolean isBorrow() {
	return borrow;
    }

    /**
     * Metodo equals para saber si dos libros son iguales
     * 
     * @return true si lo son, false en caso contrario
     */
    @Override
    public boolean equals(Item itm) {
	if (itm == this) {
	    return true;
	} else if (!(itm instanceof Book)) {
	    return false;
	} else {
	    Book book1 = (Book) itm;
	    return this.getIsbn()
		.equals(book1.getIsbn())
		    && this.getTitle()
			.equals(book1.getTitle());
	}
    }

}
