package uo.mp.newsstand.service.newsstand;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp2223.newsstand.domain.Frequency;
import uo.mp2223.newsstand.domain.Magazine;
import uo.mp2223.newsstand.domain.Newspaper;
import uo.mp2223.newsstand.domain.Order;
import uo.mp2223.newsstand.domain.Publication;
import uo.mp2223.newsstand.service.Newsstand;
import uo.mp2223.newsstand.service.NewsstandException;


public class CreateOrdersTest {
	private Newsstand ns;
	private Publication p;
	private Publication m;
	private List<Order> or;
	
	@BeforeEach
	public void setUp() throws Exception {
		ns= new Newsstand();
	}
	
	/**
	 * GIVEN: A newspaper with enough copies in stock 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewsstandException 
	 */
	@Test
	public void enoughCopiesNewspaperNoOrderTest() throws NewsstandException {
		p= new Newspaper("mundo",20,10);
		ns.addPublication(p);
		ns.createOrders();
		or=ns.getOrders();
		assertEquals(0,or.size());
	}

	/**
	 * GIVEN: A newspaper with copies in stock in the limit 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewsstandException 
	 */
	@Test
	public void copiesintheLimitNewspaperNoOrderTest() throws NewsstandException {
		p= new Newspaper("mundo",10,10);
		ns.addPublication(p);
		ns.createOrders();
		or=ns.getOrders();
		assertEquals(0,or.size());
	}
	
	/**
	 * GIVEN: A newspaper with no enough copies in stock 
	 * WHEN: generate orders
	 * THEN: new order is generated with name and 20
	 * @throws NewsstandException 
	 */
	@Test
	public void noEnoughCopiesNewspaperNoOrderTest() throws NewsstandException {
		p= new Newspaper("mundo",9,2);
		ns.addPublication(p);
		ns.createOrders();
		or=ns.getOrders();
		assertEquals(1,or.size());
		Order order = or.get(0);
		assertTrue(order.getName().equals("mundo")&&order.getQuantity()==20);
	}

	/**
	 * GIVEN: A weekly magazine with enough copies in stock 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewsstandException 
	 */
	@Test
	public void enoughCopiesWeeklyMagazineNoOrderTest() throws NewsstandException {
		m= new Magazine("revista",20,20,Frequency.WEEKLY);
		ns.addPublication(m);
		ns.createOrders();
		or= ns.getOrders();
		assertEquals(0,or.size());
	}
	
	/**
	 * GIVEN: A weekly magazine with copies in stock in the limit 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewsstandException 
	 */
	@Test
	public void limitCopiesWeeklyMagazineNoOrderTest() throws NewsstandException {
		m= new Magazine("revista",10,20,Frequency.WEEKLY);
		ns.addPublication(m);
		ns.createOrders();
		or= ns.getOrders();
		assertEquals(0,or.size());
	}
	
	/**
	 * GIVEN: A weekly magazine with copies in stock under 5 
	 * WHEN: generate orders
	 * THEN: order is generated to order 20 copies 
	 * @throws NewsstandException 
	 */
	@Test
	public void weeklyMagazineCopiesUnder5Order20() throws NewsstandException {
		m= new Magazine("revista",4,20,Frequency.WEEKLY);
		ns.addPublication(m);
		ns.createOrders();
		or= ns.getOrders();
		assertEquals(1,or.size());
		Order order = or.get(0);
		assertTrue(order.getName().equals("revista")&&order.getQuantity()==20);
	}
	
	/**
	 * GIVEN: A weekly magazine with copies in stock equals 5
	 * WHEN: generate orders
	 * THEN: order is generated to order number of copies sold
	 * @throws NewsstandException 
	 */
	@Test
	public void weeklyMagazine5CopiesOrderSold() throws NewsstandException {
		m= new Magazine("revista",5,20,Frequency.WEEKLY);
		ns.addPublication(m);
		ns.createOrders();
		or= ns.getOrders();
		assertEquals(1,or.size());
		Order order = or.get(0);
		assertTrue(order.getName().equals("revista")&&order.getQuantity()==20);
	}
	
	
	
	/**
	 * GIVEN: A monthly magazine with enough copies in stock 
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewsstandException 
	 */
	@Test
	public void enoughCopiesMonthlyMagazineNoOrderTest() throws NewsstandException {
		m= new Magazine("revista",20,20,Frequency.MONTHLY);
		ns.addPublication(m);
		ns.createOrders();
		or= ns.getOrders();
		assertEquals(0,or.size());
	}
	
	/**
	 * GIVEN: A monthly magazine with copies in stock in the limit (10)
	 * WHEN: generate orders
	 * THEN: no new order is generated
	 * @throws NewsstandException 
	 */
	@Test
	public void limitCopiesMonthlyMagazineNoOrderTest() throws NewsstandException {
		m= new Magazine("revista",10,20,Frequency.MONTHLY);
		ns.addPublication(m);
		ns.createOrders();
		or= ns.getOrders();
		assertEquals(0,or.size());
	}
	
	/**
	 * GIVEN: A monthly magazine with copies in stock under 5 
	 * WHEN: generate orders
	 * THEN: order is generated to order 20 copies 
	 * @throws NewsstandException 
	 */
	@Test
	public void monthlyMagazineCopiesUnder5Order20() throws NewsstandException {
		m= new Magazine("revista",4,20,Frequency.MONTHLY);
		ns.addPublication(m);
		ns.createOrders();
		or= ns.getOrders();
		assertEquals(1,or.size());
		Order order = or.get(0);
		assertTrue(order.getName().equals("revista")&&order.getQuantity()==20);
	}
	
	/**
	 * GIVEN: A monthly magazine with copies in stock equals 5
	 * WHEN: generate orders
	 * THEN: order is generated to order number of copies sold +
	 * 									  number of copies in stock
	 * @throws NewsstandException 
	 */
	@Test
	public void monthlyMagazine5CopiesOrderSoldPlusStock() throws NewsstandException {
		m= new Magazine("revista",5,20,Frequency.MONTHLY);
		ns.addPublication(m);
		ns.createOrders();
		or= ns.getOrders();
		assertEquals(1,or.size());
		Order order = or.get(0);
		assertTrue(order.getName().equals("revista")&&order.getQuantity()==25);
	}
	
}
