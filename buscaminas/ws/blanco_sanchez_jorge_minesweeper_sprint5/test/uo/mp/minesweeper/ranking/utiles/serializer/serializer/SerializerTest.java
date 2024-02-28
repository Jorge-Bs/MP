package uo.mp.minesweeper.ranking.utiles.serializer.serializer;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.ranking.GameRankingEntry;
import uo.mp.minesweeper.ranking.utiles.serializer.Serializer;
import uo.mp.minesweeper.session.GameLevel;

public class SerializerTest {

	private Serializer se;
	private List<String> listExpected;
	private List<String> listResult;
	private GameRankingEntry result;
	private List<GameRankingEntry> list;

	@BeforeEach
	public void setUp() throws ParseException {
		se = new Serializer();
		list = new ArrayList<>();
		listResult = new ArrayList<>();
		listExpected = new ArrayList<>();
		listExpected.add("jorge;08/02/2022;20:50;EASY;victoria;10");
		Date date = new SimpleDateFormat("dd/MM/yy HH:mm").parse("08/02/2022 20:50");
		result = new GameRankingEntry("jorge",GameLevel.EASY,10,true,date);
		list.add(result);
	}

	/**
	 * Given: null param
	 * When: se invoca al metodo
	 * Then: salta un IllegalArgumentException
	 */
	@Test
	public void nullParam() {
		try {
			se.serialize(null);
			fail("Deberia haber fallado");
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Given: una lista vacia
	 * when: se invoca al metodo
	 * then: retorna una lista vacia
	 */
	@Test
	public void emptyList() {
		List<GameRankingEntry> l = new ArrayList<>();
		listResult = se.serialize(l);
		assertEquals(0,listResult.size());
	}
	
	/**
	 * Given: una lista con un objeto correcto;
	 * when: se invoca al metodo
	 * then: la lista tiene longitu uno
	 */
	@Test
	public void correctObject() {
		listResult = se.serialize(list);
		assertEquals(1,listResult.size());
		assertTrue(listExpected.equals(listResult));
	}
	
	/**
	 * Given: una lista con un objeto correcto;
	 * when: se invoca al metodo
	 * then: la lista tiene longitu uno
	 * @throws ParseException 
	 */
	@Test
	public void correctObjetcWithDifferentsParams() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yy HH:mm").parse("08/02/2022 20:50");
		GameRankingEntry result = new GameRankingEntry("jorge",GameLevel.MEDIUM,10,true,date);
		listExpected.add("jorge;08/02/2022;20:50;MEDIUM;victoria;10");
		list.add(result);
		listResult = se.serialize(list);
		assertEquals(2,listResult.size());
		assertTrue(listExpected.equals(listResult));
	}
	

}
