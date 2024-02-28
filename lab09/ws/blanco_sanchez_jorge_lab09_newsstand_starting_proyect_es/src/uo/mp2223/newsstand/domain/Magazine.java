package uo.mp2223.newsstand.domain;

import uo.mp.util.check.ArgumentChecks;

public class Magazine extends Publication {
	
	
	
	public static int MIN_STOCK = 5;
	public static int MIN_ORDER = 20;

	private Frequency frequency;

	public Magazine(String name, int stock, int sales, Frequency freq) {
		super(name, stock, sales);
		ArgumentChecks.isTrue( freq != null);
		this.frequency = freq;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public String toString() {
		return super.toString() + "\t" + getFrequency();
	}

	@Override
	public String serialize() {
		return "magazine" 
				+ "\t" + getName() 
				+ "\t" + getStock() 
				+ "\t" + getSales() 
				+ "\t" + getFrequency();
	}

	@Override
	public Order generateOrders() {
		if (getStock() < MIN_STOCK) {
			return new Order(this.getName(), MIN_ORDER);
		} else {
			if (getFrequency() == Frequency.WEEKLY) {
				return new Order(this.getName(), getSales());
			} else {
				return new Order(this.getName(), getSales() + getStock());
			}
		}
	}

	@Override
	public Publication clone() {
		return new Magazine(this.getName(), this.getStock(), this.getSales(),this.frequency);
	}


}
