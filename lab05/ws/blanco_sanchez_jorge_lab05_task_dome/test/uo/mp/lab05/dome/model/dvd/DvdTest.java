package uo.mp.lab05.dome.model.dvd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Dvd;

/**
 * Constructor with parameters
 * Scenarios
 * 
 * - Valid arguments
 * - Invalid title, null.
 * - Invalid title, blanks.
 * - Invalid director, null
 * - Invalid director, blanks
 * - Invalid playingTime < 0
 * - Invalid playingTime = 0
 */
public class DvdTest {

    private Dvd aDvd;
    private String theTitle;
    private String theDirector;
    private int theTime;

    @BeforeEach
    public void setUp() {
	theTitle = "Star Wars";
	theDirector = "George Lucas";
	theTime = 125;
    }

    /**
     * GIVEN valid arguments
     * WHEN new Dvd(arguments)
     * THEN a new Dvd is created with that attributes
     */
    @Test
    public void validParams() {
	aDvd = new Dvd(theTitle, theDirector, theTime);

	assertEquals(theTitle, aDvd.getTitle());
	assertEquals(theDirector, aDvd.getDirector());
	assertEquals(theTime, aDvd.getPlayingTime());
	assertEquals(false, aDvd.getOwn());
	assertEquals("No comment", aDvd.getComment());
    }

    /**
     * GIVEN valid arguments, except title = null
     * WHEN new Dvd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void nullTitle() {
	theTitle = null;
	try {
	    new Dvd(theTitle, theDirector, theTime);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid title", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except title = " "
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void blankTitle() {
	theTitle = "    ";
	try {
	    new Dvd(theTitle, theDirector, theTime);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid title", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except title = ""
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void emptyTitle() {
	theTitle = "";
	try {
	    new Dvd(theTitle, theDirector, theTime);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid title", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except director = null
     * WHEN new Dvd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void nullDirector() {
	theDirector = null;
	try {
	    new Dvd(theTitle, theDirector, theTime);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid director", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except director = " "
     * WHEN new Dvd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void blankDirector() {
	theDirector = "   ";
	try {
	    new Dvd(theTitle, theDirector, theTime);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid director", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except director = ""
     * WHEN new Dvd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test

    public void emptyDirector() {
	theDirector = " ";
	try {
	    new Dvd(theTitle, theDirector, theTime);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid director", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except time = 0
     * WHEN new Dvd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void zeroTime() {
	theTime = 0;
	try {
	    new Dvd(theTitle, theDirector, theTime);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid playing time", e.getMessage());
	}
    }

    /**
     * GIVEN valid arguments, except time < 0
     * WHEN new Dvd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void negativeTime() {
	theTime = -1;
	try {
	    new Dvd(theTitle, theDirector, theTime);
	    fail("Exception expected");
	} catch (IllegalArgumentException e) {
	    assertEquals("Invalid playing time", e.getMessage());
	}
    }

}
