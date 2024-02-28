package uo.mp2223.util.log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

/**
 * A very basic implementation of a logger utility.
 * For this the date are sent to the System.err standard output.
 * The format of every lines is: <timestamp> <message>
 */
public class Logger {
	public static final String FILE="mp.log";
	public static final boolean APPEND = true;
	private static PrintStream out = System.err;

	/**
	 * Sends the string received as message to the log prefixing it with 
	 * a timestamp 
	 * @param message
	 */
	public static void log(String message) {
//		out.print( new Date()  + " ");
//		out.println( message );
		try {
			out = new PrintStream(new FileOutputStream(FILE,APPEND));
			try {
				out.print(new Date()+ " ");
				out.println(message);
			}finally {
				out.close();
			}
		}catch(FileNotFoundException e) {
				printToConsole();
				out.println(message);
			}
	}
	
	
	private static void printToConsole() {
		out= System.err;
		out.println("No se ha podido guardar en el fichero log");
		out.println(new Date()+ " ");
	}
		
	/**
	 * Sends the full stack trace of the exception received to the log
	 * prefixing it with a timestamp 
	 * @param t, the exception to be logged
	 */
	public static void log(Throwable t) {
		out.print( new Date()  + " ");
		t.printStackTrace( out );
	}
}
