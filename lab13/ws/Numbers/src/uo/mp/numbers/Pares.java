package uo.mp.numbers;

public class Pares implements Runnable{
	private void printNumbers() {
		for(int i=2;i<=100;i+=2) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public void run() {
		printNumbers();
	}
}
