package uo.mp2223.util.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import uo.mp.lab.util.check.ArgumentChecks;

public class ArrayList<T> extends AbstractList<T>{

	public static final int INITIAL_CAPACITY=10;
	private T[] elements;
	
	
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int initialCapacity) {
		ArgumentChecks.isTrue(initialCapacity>0,"capacidad invalida");
		elements = (T[]) new Object[initialCapacity];
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		elements =(T[])new Object[elements.length];
		numberOfElements=0;
	}

	@Override
	public T get(int index) {
		ArgumentChecks.isTrue(index>=0 && index<size(),"indice invalido");
		return elements[index];
	}

	@Override
	public T set(int index, T element) {
		ArgumentChecks.isTrue(index >=0 && index<size(),"indice invalido");
		ArgumentChecks.isTrue(element!=null,"objeto invalido");
		T object = elements[index];
		elements[index]=element;
		return object;
	}

	@Override
	public void add(int index, T element) {
//		if(index<0) {
//			throw new IndexOutOfBoundsException("Indice invalido");
//		}
//		ArgumentChecks.isTrue(element!=null,"objeto invalido");
//		if(index>=elements.length-1) {
//			moreMemory(size()+1);
//		}
//		if(elements[index]==null && index!=size()) {
//			elements[index]=element;
//		}else if(index-1>=0 && elements[index-1]==null){
//			elements[index-1]=element;
//		}else {
//			for(int i=size(); i>index; i--) {
//				T obj = elements[i];
//				elements[i] = elements[i-1];
//				elements[i+1]=obj;}
//			elements[index] = element;
//		}
//		numberOfElements++;
		
		if(index<0 || index>size()) {
			throw new IndexOutOfBoundsException("Indice invalido");
		}
		ArgumentChecks.isTrue(element!=null,"objeto invalido");
		if(size()+1>=elements.length-1) {
			moreMemory(size()+1);
		}
		
		for(int i=size();i>index;i--) {
			elements[i]=elements[i-1];
		}
		elements[index]=element;
		numberOfElements++;
	}
	
	@SuppressWarnings("unchecked")
	private void moreMemory(int amount) {
		if (amount > elements.length) {
			Object[] aux = new Object[Math.max( amount,
			2*elements.length)];
			System.arraycopy(elements, 0, aux, 0,
			elements.length);
			elements=(T[]) aux;
		}
	}

	@Override
	public T remove(int index) {
		if(index<0 || index>=size() && elements[index]==null ||size()==0) {
			throw new IndexOutOfBoundsException("indice invalido");
		}
		try {
			T value = elements[index];
			elements[index]=null;
			for(int i=index; i<size()-1; i++) {
				elements[i] = elements[i+1];
				elements[i+1]=null;
			}
			numberOfElements--;
			return value;
		}catch(Exception e) {
			return null;
		}

	}

	@Override
	public int indexOf(Object o) {
		for(int i=0;i<size();i++)
			if(elements[i].equals(o)) {
				return i;
			}
		return -1;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0;i<size()-1;i++) {
			sb.append(elements[i].toString()+", ");
		}if(size()==0) {
			sb.append("]");
		}else {
			sb.append(elements[size()-1].toString()+"]");
		}
		
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<T>{

		int index;
		T lastReturned;
			
		
		@Override
		public boolean hasNext() {
			return index<size();
		}

		@Override
		public T next() {
			if(hasNext()) {
				lastReturned=elements[index];
				index++;
				return lastReturned;
			}else {
				throw new NoSuchElementException("No hay elementos en la lista");
			}
		}
		
		public void remove() {
			ArrayList.this.remove(index);
		}
		
	}

}
