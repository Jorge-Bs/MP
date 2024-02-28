package uo.mp.tg1.ruralvia;

import uo.mp.tg1.ruralvia.interfacerepositiory.Transaction;

public class PaymentGateway {
	private static final int NUMBER = 0;
	private static final int MONTH = 1;
	private static final int YEAR = 2;

	private Object[][] validCreditCards = { 
			{ "11111111111111111111", 12, 2018 }, 
			{ "22222222222222222222", 12, 2018 },
			{ "11111111111111114444", 1, 2019 }, 
			{ "33333333333333333333", 7, 2017 } 
		};

	public boolean isValid(Transaction transaction) {
		for (Object[] row : validCreditCards) {
			String pan = (String) row[NUMBER]; 
			if ( pan.equals(transaction.getCreditCardNumber()) ) {
				return row[MONTH].equals(transaction.getMonth()) 
						&& row[YEAR].equals(transaction.getYear());
			}
		}
		return false;
	}
}
