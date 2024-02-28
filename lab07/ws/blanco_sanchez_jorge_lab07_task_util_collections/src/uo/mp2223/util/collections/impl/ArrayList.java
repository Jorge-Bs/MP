package uo.mp2223.util.collections.impl;

import uo.mp.lab.util.check.ArgumentChecks;

public class ArrayList extends AbstractList{

	public static final int INITIAL_CAPACITY=10;
	private Object[] elements;
	
	
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	public ArrayList(int initialCapacity) {
		ArgumentChecks.isTrue(initialCapacity>0,"capacidad invalida");
		elements = new Object[initialCapacity];
	}
	
	

	@Override
	public void clear() {
		elements = new Object[elements.length];
		numberOfElements=0;
	}

	@Override
	public Object get(int index) {
		ArgumentChecks.isTrue(index>=0 && index<size(),"indice invalido");
		return elements[index];
	}

	@Override
	public Object set(int index, Object element) {
		ArgumentChecks.isTrue(index >=0 && index<size(),"indice invalido");
		ArgumentChecks.isTrue(element!=null,"objeto invalido");
		Object object = elements[index];
		elements[index]=element;
		return object;
	}

	@Override
	public void add(int index, Object element) {
		if(index<0) {
			throw new IndexOutOfBoundsException("Indice invalido");
		}
		ArgumentChecks.isTrue(element!=null,"objeto invalido");
		if(index>=elements.length) {
			moreMemory(size()+1);
		}
		for(int i=size(); i>index; i--) {
			elements[i] = elements[i-1];}
		elements[index] = element;
		numberOfElements++;
		
	}
	
	private void moreMemory(int amount) {
		if (amount > elements.length) {
			Object[] aux = new Object[Math.max( amount,
			2*elements.length)];
			System.arraycopy(elements, 0, aux, 0,
			elements.length);
			elements=aux;
		}
	}

	@Override
	public Object remove(int index) {
		if(index<0 || index>=size()) {
			throw new IndexOutOfBoundsException("indice invalido");
		}
		Object value = elements[index];
		for(int i=index; i<size()-1; i++) {
			elements[i] = elements[i+1];
		}
		numberOfElements--;
		return value;

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
	

}
