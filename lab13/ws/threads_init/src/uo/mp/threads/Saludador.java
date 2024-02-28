package uo.mp.threads;

public class Saludador  extends Thread{
	
	String nombre;
	int veces;
	
	public Saludador(String nombre, int veces) {
		this.nombre = nombre;
		this.veces = veces;
	}
	
	public void saludar() {
		for (int i=0; i< veces; i++) {
			System.out.println("Hola " + nombre + "!!");
		}
	}
	
	public void run() {
		saludar();
	}

	

	

	

	

}
