package uo.mp.exception.util;

import java.io.PrintStream;

/**
 * The most simple possible implementation of a logger system
 * A real logger should write to a specific file with an more elaborated format
 * such as <date> - <level> - <class sending the message> - <message>
 * @author alb
 */
public class Log {
	
	private static PrintStream out = System.err;

	public static void log(String message) {
		out.println( message );
	}

}
