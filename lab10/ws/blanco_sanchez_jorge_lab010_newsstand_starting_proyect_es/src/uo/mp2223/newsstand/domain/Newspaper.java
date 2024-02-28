package uo.mp2223.newsstand.domain;

public class Newspaper extends Publication {

	public Newspaper(String name, int stock, int sales) {
		super(name, stock, sales);
	}

	@Override
	public Order generateOrders() {
		return new Order(getName(), getSales() + (getStock() * 2));
	}

	@Override
	public String serialize() {
		return "newspaper" 
				+ "\t" + getName() 
				+ "\t" + getStock() 
				+ "\t" + getSales(); 
	}

	@Override
	public Publication clone() {
		return new Newspaper(this.getName(), this.getStock(), this.getSales());
	}

}
