package uo.mp2223.util.collections.impl;

import uo.mp.lab.util.check.ArgumentChecks;

public class LinkedList extends AbstractList {


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
	public Object get(int index) {
		Node no = getNode(index);
		return no==null ? null:no.element;
	}

	@Override
	public Object set(int index, Object element) {
		Node tmp= getNode(index);
		Object value = tmp.element;
		tmp.element=element;
		return value;
	}

	@Override
	public void add(int index, Object element) {
		if(index<0) {
			throw new IndexOutOfBoundsException("Indice invalido");
		}
		ArgumentChecks.isTrue(element!=null,"elemento invalido");
		if(size()==0) {
			head=new Node(element,null);
			numberOfElements++;
		}
		else if (index==0) {
			Node nex = head.next;
			head = new Node(element,nex);
			numberOfElements++;
		}else {
			Node previous = getNode(index-1);
			previous.next = new Node(element, previous.next);
			numberOfElements++;
			}
	}

	@Override
	public Object remove(int index) {
		if(index<0 || index>=size()) {
			throw new IndexOutOfBoundsException("indice invalido");
		}
		if (isEmpty()) return null;
		Object value;
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
	
	private class Node {
		Object element;
		Node next;
		
		Node (Object element, Node next){
			this.element=element;
			this.next=next;
		}
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

}
