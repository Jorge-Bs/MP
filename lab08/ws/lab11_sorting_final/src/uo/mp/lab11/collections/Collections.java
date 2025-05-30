package uo.mp.lab11.collections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Collections {

	public static <T> void sort(List<T> list) throws InvalidElementToSortException {
		checkComparableElements(list);
		List<T> sorted = new LinkedList<>();
		for (T element:list) {
			int index = getPositionInSorted(element, sorted);
			sorted.add(index, element);
		}
		makeCopy(sorted, list);
	}
	
	private static <T> void makeCopy(List<T> origin, List<T> destination) {
		destination.clear();
		for (T element: origin) {
			destination.add(element);
		}		
	}

	@SuppressWarnings("unchecked")
	private static <T> int getPositionInSorted(T element, List<T> sorted ) {
		int index = 0;
		for (T orderedElement: sorted) {
			if ( ((Comparable<T>) orderedElement).compareTo(element) > 0) {
				return index;
			}
			index ++;
		}
		return sorted.size();
	}
	
	private static <T> void checkComparableElements(List<T> list) throws InvalidElementToSortException {
		if (! (list.get(0) instanceof Comparable<?>) ) {
			throw new InvalidElementToSortException("No es posible comparar elementos de este tipo de lista");
		}
	}

	public static <T> void sort(List<T> list, Comparator<T> comparator) {
		//checkComparableElements(list);
		List<T> sorted = new LinkedList<>();
		for (T element:list) {
			int index = getPositionInSorted(element, sorted, comparator);
			sorted.add(index, element);
		}
		makeCopy(sorted, list);
	}

	@SuppressWarnings("unchecked")
	private static <T> int getPositionInSorted(T element, List<T> sorted, Comparator<T> comparator) {
		int index = 0;
		for (T orderedElement: sorted) {
			if ( ( ((Comparator<T>) orderedElement).compare(orderedElement, element)) > 0) {
				return index;
			}
			index ++;
		}
		return sorted.size();
	}
	
	
	
}
