package uo.mp.lab03.dome.model.dvd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.dome.model.Dvd;

/**
 * Dvd::setComment(arg)
 * 
 * - Right comment
 * - null argument
 * - empty string
 * - argument does not contain meaningful chars
 */
public class SetCommentTest {
    private Dvd aDVD;
    private String theTitle;
    private String theDirector;
    private int theTime;

    @BeforeEach
    public void setUp() {
	theTitle = "Star Wars";
	theDirector = "George Lucas";
	theTime = 125;
	aDVD = new Dvd(theTitle, theDirector, theTime);
    }

    /**
     * GIVEN dvd with "No comment" comment
     * WHEN call setComment with other comment full of meaningful chars
     * THEN comment is changed to new string
     */
    @Test
    public void validComment() {
	aDVD.setComment("Excellent");

	assertEquals("Excellent", aDVD.getComment());
    }

    /**
     * GIVEN dvd with a comment
     * WHEN call setComment with null
     * THEN comment unchanged
     */
    @Test
    public void nullComment() {
	aDVD.setComment("Excellent");
	aDVD.setComment(null);

	assertEquals("Excellent", aDVD.getComment());
    }

    /**
     * GIVEN dvd with a comment
     * WHEN call setComment with ""
     * THEN comment unchanged
     */
    @Test
    public void emptyComment() {
	aDVD.setComment("Excellent");
	aDVD.setComment("");

	assertEquals("Excellent", aDVD.getComment());
    }

    /**
     * GIVEN dvd with a comment
     * WHEN call setComment with " "
     * THEN comment unchanged
     */
    @Test
    public void blankComment() {
	aDVD.setComment("Excellent");
	aDVD.setComment("      ");

	assertEquals("Excellent", aDVD.getComment());
    }
}