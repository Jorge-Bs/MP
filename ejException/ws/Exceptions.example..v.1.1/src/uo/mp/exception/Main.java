package uo.mp.exception;

import uo.mp.exception.util.Console;
import uo.mp.exception.util.Log;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
				
		try {
			
			String fileName = Console.readString("File name");
			double balance = new Accounter(fileName).processFile();
			Console.show("The balance in your account is: " + balance);
			
		} catch (RuntimeException e) {
			handleDefaultRuntimeException(e);
		} catch (Exception e) {
			handleDefaultException(e);
		}

		
	}

	/**
	 * Muestra un mensaje al usuario sobre la naturaleza del problema
	 * @param e
	 */
	private void handleDefaultException(Exception e) {
		Console.show( "Ha habido problemas que requieren su atenci�n" );
		Console.show( e.getMessage() );
	}

	/**
	 * Muestra un mensaje al usuario final, pero registra el problema real en un
     * fichero de registro para el personal t�cnico para poder analizar el problema
	 * @param e
	 */
	private void handleDefaultRuntimeException(RuntimeException e) {
		Console.show("Debido a algunos problemas t�cnicos, el programa ha tenido errores.");
		Console.show("P�ngase en contacto con el personal t�cnico mostrando el contenido de este mensaje.");
		Log.log( e.getMessage() );		
	}

}
