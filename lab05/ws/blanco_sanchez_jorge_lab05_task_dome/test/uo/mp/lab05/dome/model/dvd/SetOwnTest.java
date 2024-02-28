package uo.mp.lab05.dome.model.dvd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Dvd;

/**
 * Dvd::setOwn(boolean)
 *
 * - being own to own
 * - being own to not own
 * - being not own to not own
 * - being not own to own
 */
public class SetOwnTest {
    private Dvd aDVD;
    private String theTitle;
    private String theDirector;
    private int theTime;

    @BeforeEach
    public void setUp() {
	theTitle = "La guerra de las Galaxias";
	theDirector = "George Lucas";
	theTime = 125;
	aDVD = new Dvd(theTitle, theDirector, theTime);
    }

    /**
     * GIVEN dvd owned
     * WHEN call setOwn ( true )
     * THEN dvd not changed
     * 
     */
    @Test
    public void trueToTrue() {
	aDVD.setOwn(true);
	aDVD.setOwn(true);
	assertEquals(true, aDVD.getOwn());
    }

    /**
     * GIVEN dvd owned
     * WHEN call setOwn ( false )
     * THEN dvd not owned
     * 
     */
    @Test
    public void trueToFalse() {
	aDVD.setOwn(true);
	aDVD.setOwn(false);
	assertEquals(false, aDVD.getOwn());
    }

    /**
     * GIVEN dvd not owned
     * WHEN call setOwn ( false )
     * THEN dvd not changed
     * 
     */
    @Test
    public void falseToFalse() {
	aDVD.setOwn(false);
	aDVD.setOwn(false);
	assertEquals(false, aDVD.getOwn());
    }

    /**
     * GIVEN dvd not owned
     * WHEN call setOwn ( true )
     * THEN dvd owned
     * 
     */
    @Test
    public void falseToTrue() {
	aDVD.setOwn(false);
	aDVD.setOwn(true);
	assertEquals(true, aDVD.getOwn());
    }

}