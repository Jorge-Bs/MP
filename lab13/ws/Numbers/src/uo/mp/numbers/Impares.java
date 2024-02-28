package uo.mp.numbers;

public class Impares extends Thread{

	private void printNumbers() {
		for(int i=1;i<=99;i+=2) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public void run() {
		printNumbers();
	}
}
