package uo.mp.exception;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 /**
 * Este es un lector de ficheros falso.
 * Lo usamos en lugar de un FileReader real para no añadir complejidad extra.
 * Los Streams (o flujos) de entrada/salida se verán en el tema 
 * 
 * @author alb
 */
public class FileReader {
	
	public FileReader(String fName) throws FileNotFoundException {
		if ( ! "data.dat".equals( fName )) {
			throw new RuntimeException("The file does not exist");
		}
	}

	public List<String> readLines() throws IOException {
		return Arrays.asList( new String[]{
				"1/12/2016	Initial balance	1000.00",
				"12/12/2016	Expenses in the supermarket	-123.25",
				"13/12/2016	Salary	5635.00",
				"13/12/2016	Credit card clearing	-1A256.35"
			});
	}

	public void close() throws IOException {
		// TODO Auto-generated method stub
	}

}
