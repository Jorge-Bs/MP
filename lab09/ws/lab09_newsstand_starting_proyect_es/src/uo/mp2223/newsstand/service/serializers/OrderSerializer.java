package uo.mp2223.newsstand.service.serializers;

import java.util.List;

import uo.mp2223.newsstand.domain.Order;
import uo.mp2223.newsstand.exception.NotYetImplementedException;

public class OrderSerializer {

	/**
	 * Returns a list of String out of a list of Orders
	 * @param orders, the list of orders to convert
	 * @return a list of String-serialized orders
	 */
	public List<String> serialize(List<Order> orders) {
		throw new NotYetImplementedException();
	}

}
