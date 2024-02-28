package uo.mp.lab05.dome.model;

public interface Borrowable {

    /**
     * Devuelve true si el item se puede prestar
     * 
     * @return boolean
     */
    boolean isAvailable();

    /**
     * Presta el item
     */
    void borrow();

    /**
     * Devuelve el item
     */
    void giveBack();

    /**
     * Devuelve true si el item está prestado
     * 
     * @return boolean
     */
    boolean isBorrow();

}
