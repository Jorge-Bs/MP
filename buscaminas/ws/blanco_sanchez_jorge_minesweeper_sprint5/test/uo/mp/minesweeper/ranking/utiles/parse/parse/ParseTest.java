package uo.mp.minesweeper.ranking.utiles.parse.parse;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.minesweeper.ranking.GameRankingEntry;
import uo.mp.minesweeper.ranking.utiles.parse.Parse;
import uo.mp.minesweeper.session.GameLevel;

public class ParseTest {
	
	private Parse pa;
	private List<String> list;
	private GameRankingEntry result;
	private List<GameRankingEntry> listResultExpected;
	private List<GameRankingEntry> listResult;

	@BeforeEach
	public void setUp() throws Exception {
		pa= new Parse();
		list = new ArrayList<>();
		listResult= new ArrayList<>();
		listResultExpected = new ArrayList<>();
		list.add("jorge;08/02/2022;20:50;EASY;victoria;10");
		Date date = new SimpleDateFormat("dd/MM/yy HH:mm").parse("08/02/2022 20:50");
		result = new GameRankingEntry("jorge",GameLevel.EASY,10,true,date);
		listResultExpected.add(result);
	}

	
	
	/**
	 * Given: parametro null
	 * When: se invoca al metod
	 * Then: se produce un IllegalArgumentException
	 */
	@Test
	public void nullParam() {
		try {
			pa.parse(null);
			fail("Deberia haber fallado");
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * GIven: una lista vacia
	 * When: se invoca al metodo
	 * Then: la lista tine longitud 0
	 */
	@Test
	public void emptyList() {
		List<String> l = new ArrayList<>();
		listResult = pa.parse(l);
		assertEquals(0,listResult.size());
		
	}
	
	/**
	 * Given: una lista con un objeto correto
	 * When: se invoca al metodo
	 * then: la lista tine longitud 1
	 */
	@Test
	public void correctString() {
		listResult = pa.parse(list);
		assertEquals(1,listResult.size());
		assertTrue(listResult.equals(listResultExpected));
	}
	
	/**
	 * Given: una lista con un objeto correto y uno incorrecto: username
	 * When: se invoca al metodo
	 * then: la lista tine longitud 1
	 */
	@Test
	public void invalidUsername() {
		
		list.add("Jorge;08/02/2022;20:50;EASY;victoria;10");
		
		listResult = pa.parse(list);
		assertEquals(1,listResult.size());
		assertTrue(listResult.equals(listResultExpected));
	}
	
	/**
	 * Given: una lista con un objeto correto y uno incorrecto: length
	 * When: se invoca al metodo
	 * then: la lista tine longitud 1
	 */
	@Test
	public void invalidAmountLess() {
		
		list.add("jorge;08/02/2022;20:50;EASY;victoria");
		
		listResult = pa.parse(list);
		assertEquals(1,listResult.size());
		assertTrue(listResult.equals(listResultExpected));
	}
	
	/**
	 * Given: una lista con un objeto correto y uno incorrecto: length
	 * When: se invoca al metodo
	 * then: la lista tine longitud 1
	 */
	@Test
	public void invalidAmountMore() {
		
		list.add("jorge;08/02/2022;20:50;EASY;victoria;10;10");
		
		listResult = pa.parse(list);
		assertEquals(1,listResult.size());
		assertTrue(listResult.equals(listResultExpected));
	}
	
	/**
	 * Given: una lista con un objeto correto y uno incorrecto: valores desordenados
	 * When: se invoca al metodo
	 * then: la lista tine longitud 1
	 */
	@Test
	public void invalidOrder() {
		
		list.add("08/02/2022;20:50;EASY;victoria;10;jorge");
		
		listResult = pa.parse(list);
		assertEquals(1,listResult.size());
		assertTrue(listResult.equals(listResultExpected));
	}

}
