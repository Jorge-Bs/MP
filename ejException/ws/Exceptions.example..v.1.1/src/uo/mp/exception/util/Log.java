package uo.mp.exception.util;

import java.io.PrintStream;

/**
 * Implementaci�n simple de la clase Log
 * Un logger escribir�a en un fichero espec�fico en un formato m�s elaborado
 * 
 * @author MP
 */
public class Log {
	
	private static PrintStream out = System.err;

	public static void log(String message) {
		out.println( message );
	}

}
