package uo.mp.threads;

public class Main {
	public static void main(String[] args) {		
		Saludador s1 = new Saludador("Jorge",10);
		Saludador s2 = new Saludador("Pablo",10);
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException e) {
			
		}
		
		System.out.print("No te has cansado?");
	}
}
