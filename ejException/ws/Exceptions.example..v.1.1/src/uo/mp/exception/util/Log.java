package uo.mp.exception.util;

import java.io.PrintStream;

/**
 * Implementación simple de la clase Log
 * Un logger escribiría en un fichero específico en un formato más elaborado
 * 
 * @author MP
 */
public class Log {
	
	private static PrintStream out = System.err;

	public static void log(String message) {
		out.println( message );
	}

}
