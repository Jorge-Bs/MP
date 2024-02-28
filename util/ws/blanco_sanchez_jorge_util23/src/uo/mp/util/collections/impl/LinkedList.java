package uo.mp.util.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import uo.mp.util.check.ArgumentChecks;


public class LinkedList<T> extends AbstractList<T> {


	Node head;
	
	
	public LinkedList() {
		head = null;
		numberOfElements=0;
	}
	


	@Override
	public void clear() {
		head=null;
		numberOfElements=0;
	}

	private Node getNode(int index) {
		ArgumentChecks.isTrue(index>=0 && index<numberOfElements,"indice invalido" );
		int position = 0;
		Node node = head;
		while (position < index) {
		node = node.next;
		position++; 
		}
		return node;
	}
	
	@Override
	public T get(int index) {
		Node no = getNode(index);
		return no==null ? null:no.element;
	}

	@Override
	public T set(int index, T element) {
		Node tmp= getNode(index);
		T value = tmp.element;
		tmp.element=element;
		return value;
	}

	@Override
	public void add(int index, T element) {
		if(index<0) {
			throw new IndexOutOfBoundsException("Indice invalido");
		}
		ArgumentChecks.isTrue(element!=null,"elemento invalido");
		if(size()==0) {
			head=new Node(element,null);
			numberOfElements++;
		}
		else if (index==0) {
			Node nex = head;
			head = new Node(element,nex);
			numberOfElements++;
		}else {
			if(index>size()) {
				add(size(),element);
			}else {
				Node previous = getNode(index-1);
				previous.next = new Node(element, previous.next);
				numberOfElements++;
			}
		}
	}

	@Override
	public T remove(int index) {
		if(index<0 || index>=size()) {
			throw new IndexOutOfBoundsException("indice invalido");
		}
		if (isEmpty()) return null;
		T value;
		if (index == 0) { 
			value = head.element;
			head = head.next;
			numberOfElements--;
		} else {
		Node previous = getNode(index - 1);
		value = previous.next.element;
		previous.next = previous.next.next;
		numberOfElements--;
		}
		
		return value; }


	@Override
	public int indexOf(Object o) {
		Node tmp=head;
		int contador=0;
		while(tmp!=null) {
			if(tmp.element.equals(o)) {
				return contador;
			}
			tmp = tmp.next;
			contador++;
		}
		return -1;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node temp=head;
		sb.append("[");
		while(temp!=null) {
			sb.append(temp.element);
			if (temp.next != null) {
	            sb.append(", ");
	        }
			temp = temp.next;
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<T>{
		
		Node next;
		int nextIndex;
		Node lastReturned;
		
		public LinkedListIterator() {
			next=head;
		}
	
		@Override
		public boolean hasNext() {
			return next!=null;
		}
	
		@Override
		public T next() {
			if(hasNext()) {
				lastReturned= next;
				next=next.next;
				nextIndex++;
				return lastReturned.element;
			}else {
				throw new NoSuchElementException("No hay elementos en la lista");
			}
			
		}
		
		public void remove() {
			LinkedList.this.remove(indexOf(lastReturned.element));
		}
	}

	private class Node {
		T element;
		Node next;
		
		Node (T element, Node next){
			this.element=element;
			this.next=next;
		}
		
		public String toString() {
			StringBuilder result = new StringBuilder();
			if(next!=null) {
				result.append(element.toString());
		}
			return result.toString();
	}
	}
}


