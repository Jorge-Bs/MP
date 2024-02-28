package uo.mp.exception;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que se encarga de leer el fichero. 
 * No se usa un FileReader real para no añadir complejidad.
 * 
 * 
 * @author MP
 */
public class FileReader {

	public FileReader(String fName)  throws FileNotFoundException {
		if ( ! "data.dat".equals( fName )) {
			throw new RuntimeException("El fichero no existe");
		}
	}

	public List<String> readLines() throws IOException {
		return Arrays.asList( new String[]{
				"1/12/2015	Saldo inicial	1000.00",
				"12/12/2015	Compra en el supermercado	-123.25",
				"13/12/2015	Salario	5635.00",
				"13/12/2015	Gasto con tarjeta	-1A256.35"
			});
	}

	public void close() throws IOException {
		// cierra el fichero
	}

}
