package uo.mp.lab05.dome.model.cd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Cd;
import uo.mp.lab05.dome.model.Item;

/**
 * Cd::setComment(arg)
 * 
 * - Right comment
 * - null argument
 * - empty string
 * - argument does not contain meaningful chars
 */
public class SetCommentTest {
    private Item aCD;
    private String theTitle;
    private String theArtist;
    private int theTime;
    private int theTracks;

    @BeforeEach
    public void setUp() {
	theTitle = "Come Together";
	theArtist = "Beatles";
	theTime = 70;
	theTracks = 4;
	aCD = new Cd(theTitle, theArtist, theTracks, theTime);
    }

    /**
     * GIVEN cd with "No comment" comment
     * WHEN call setComment with other comment full of meaningful chars
     * THEN comment is changed to new string
     */
    @Test
    public void rightComment() {
	aCD.setComment("Excellent");
	assertEquals("Excellent", aCD.getComment());
    }

    /**
     * GIVEN cd with a comment
     * WHEN call setComment with null
     * THEN comment unchanged
     */
    @Test
    public void nullComment() {
	aCD.setComment("Excellent");
	aCD.setComment(null);

	assertEquals("Excellent", aCD.getComment());
    }

    /**
     * GIVEN cd with a comment
     * WHEN call setComment with ""
     * THEN comment unchanged
     */
    @Test
    public void emptyComment() {
	aCD.setComment("Excellent");
	aCD.setComment("");

	assertEquals("Excellent", aCD.getComment());
    }

    /**
     * GIVEN cd with a comment
     * WHEN call setComment with " "
     * THEN comment unchanged
     */
    @Test
    public void blankComment() {
	aCD.setComment("Excellent");
	aCD.setComment("      ");

	assertEquals("Excellent", aCD.getComment());
    }
}
