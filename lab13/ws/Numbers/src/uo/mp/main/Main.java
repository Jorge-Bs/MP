package uo.mp.main;

import uo.mp.numbers.Impares;
import uo.mp.numbers.Pares;

public class Main {

	public static void main(String[] args) {
		Pares p1= new Pares();
		Impares imp2 = new Impares();
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(imp2);
		
		t1.start();
		try {
			t1.join();
		}catch(InterruptedException e) {
			
		}
		t2.start();
		try {
			t2.join();
		}catch(InterruptedException e) {
			
		}
		
		System.out.println("Final");

	}
	


}
