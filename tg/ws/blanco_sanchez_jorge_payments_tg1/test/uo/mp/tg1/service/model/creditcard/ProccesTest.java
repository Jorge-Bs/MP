package uo.mp.tg1.service.model.creditcard;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.tg1.payments.model.CreditCard;

public class ProccesTest {

	@Test
	public void valid() {
		CreditCard card = new CreditCard("100", 100.0, "11111111111111111111", 12, 2018);
		card.valid();
		assertTrue(card.isValid());
	}
	
	@Test
	public void noValid() {
		CreditCard card = new CreditCard("100", 100.0, "1111111111111111", 12, 2015);
		card.valid();
		assertFalse(card.isValid());
	}

}
