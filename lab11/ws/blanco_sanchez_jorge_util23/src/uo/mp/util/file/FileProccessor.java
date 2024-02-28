package uo.mp.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import uo.mp.util.check.ArgumentChecks;



class FileProccessor {
	
	/**
	 * Lee cada linea del buffered dado como parametro y devuelve una lista de string con la informacion
	 * que contiene
	 * @param inFileName
	 * @param in
	 * @return Lista con string
	 * @throws FileNotFoundException
	 * @throws NewsstandException
	 */
	protected List<String> readLines(BufferedReader in) throws FileNotFoundException{
		ArgumentChecks.isTrue(in!=null,"BufferReader no puede ser null");
		List<String> result = new LinkedList<>();
		try {
			try {
				String line;
				while((line=in.readLine())!=null) {
					result.add(line);
				}
				
			}finally {
				in.close();
			}
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	/**
	 * Escribe en el archivo dadado como parametro la informacion de la lista, se recibe el bufferedwriter a utilizar
	 * @param wr
	 * @param lines
	 */
	protected void writeLines(BufferedWriter wr, List<String> lines) {
		validateParamsWriter(wr, lines);
		try {
			try {
				for(String line:lines) {
					wr.write(line);
					wr.newLine();
				}
			}finally {
				wr.close();
			}
		}catch (IOException e) {
			throw new RuntimeException("Error en la lectura del fichero "
					+": "+ e.getMessage());
		}
	}
	
	
	
	/**
	 * Comprueba que los parametros son validos para el procesamiento
	 * @param name
	 * @param lines
	 */
	private void validateParamsWriter(BufferedWriter wr,List<String> lines) {
		ArgumentChecks.isTrue(wr!=null,"Buffered no puede ser null");
		ArgumentChecks.isTrue(lines!=null);
	}

}
