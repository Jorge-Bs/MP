package uo.mp2223.newsstand.service.sort;

import java.util.Comparator;

import uo.mp2223.newsstand.domain.Publication;

public class BySalesSorter implements Comparator<Publication>{

	@Override
	public int compare(Publication o1, Publication o2) {
		return o1.getSales()-o2.getSales();
	}

}
