package uo.mp.minesweeper.util.log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

import uo.mp.minesweeper.util.check.ArgumentChecks;

public class FileLogger implements SimpleLogger {

	
	public static final boolean APPEND = true;
	private static PrintStream out = System.err;
	
	private static String file;
	
	
	
	public FileLogger(String file) {
		setFile(file);
	}
	
	private static void setFile(String file) {
		ArgumentChecks.isTrue(file!=null && !file.isBlank(),"Archivo invalido");
		FileLogger.file = file;
	}

	/**
	 * guarda el mensaje en un fichero
	 */
	public void log(Exception e) {
		try {
			out = new PrintStream (new FileOutputStream ( file, APPEND ));
		    try {
		    	out.print( new Date()  + " ");
				out.println(e.getMessage());
		    } finally {
		    	out.close(); 
		    }
		} catch (FileNotFoundException a) {
			printToConsole();
			out.println(a.getMessage());
		}	
	}

	private static void printToConsole() {
		out = System.err;
		out.println("No se ha podido guardar el log en el fichero\n");
		out.print( new Date() + " ");
	}
	
	

}
