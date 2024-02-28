package uo.mp2223.util.collections.main;


import uo.mp2223.util.collections.Collections;
import uo.mp2223.util.collections.List;
import uo.mp2223.util.collections.exception.InvalidElementToSortException;
import uo.mp2223.util.collections.impl.ArrayList;
import uo.mp2223.util.collections.impl.LinkedList;

public class MainOrder {

	public static void main(String[] args) throws InvalidElementToSortException {
		List<Integer> l1 = new ArrayList<>();
		l1.add(12);
		l1.add(3);
		l1.add(11);
		for(Integer inte:l1) {
			System.out.println(inte);
		}
		Collections.sort(l1);
		for(Integer inte:l1) {
			System.out.println(inte);
		}
	}

}
