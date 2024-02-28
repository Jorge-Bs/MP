package uo.mp2223.newsstand.domain;

import uo.mp.util.check.ArgumentChecks;

public class Order {
	private String name;
	private int quantity;
	
	public Order(String name, int quantity){
		ArgumentChecks.isTrue( name != null );
		ArgumentChecks.isTrue( name.trim().isEmpty() == false );
		ArgumentChecks.isTrue( quantity > 0 );
		
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public String toString(){
		return "Order: " + getName() + "\t" + getQuantity();
	}
	
	public String serialize(){
		return  getName() + "\t" + getQuantity();
	}
	
	public Order clone() {
		return new Order(this.name,this.quantity);
	}
	
}
