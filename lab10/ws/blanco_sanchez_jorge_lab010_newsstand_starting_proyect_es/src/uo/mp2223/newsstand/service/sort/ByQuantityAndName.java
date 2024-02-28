package uo.mp2223.newsstand.service.sort;

import java.util.Comparator;

import uo.mp2223.newsstand.domain.Order;



public class ByQuantityAndName implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		int value= o1.getQuantity()-o2.getQuantity();
		value = value==0 ? o1.getName().compareTo(o2.getName()): value;
		return value;
	}

}
