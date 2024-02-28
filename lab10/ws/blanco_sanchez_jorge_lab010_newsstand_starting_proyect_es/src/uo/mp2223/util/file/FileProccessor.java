package uo.mp2223.util.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import uo.mp.util.check.ArgumentChecks;
import uo.mp2223.newsstand.service.NewsstandException;

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
	protected List<String> readLines(BufferedReader in) throws FileNotFoundException, NewsstandException{
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
	 * @param outFileName
	 * @param wr
	 * @param lines
	 */
	protected void writeLines(String outFileName, BufferedWriter wr, List<String> lines) {
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
			throw new RuntimeException("Error en la lectura del fichero "+ outFileName
					+": "+ e.getMessage());
		}
	}
	
	/**
	 * Valida el nomnre del archivo de lectura
	 * @param name
	 * @throws NewsstandException
	 */
	protected void validateNameReader(String name) throws NewsstandException {
		ArgumentChecks.isTrue(name!=null && !name.isEmpty() && !name.isBlank(), "Nombre invalido");
		checkName(name);
	}
	
	/**
	 * Comprueba que el nombre tenga una longitud superior a 5 caracteres
	 * @param name
	 * @throws NewsstandException
	 */
	private void checkName(String name) throws NewsstandException {
		if (name.length()<5) {
			throw new NewsstandException("Nombre invalido");
		}
	}
	
	/**
	 * Comprueba que los parametros son validos para el procesamiento
	 * @param name
	 * @param lines
	 */
	protected void validateParamsWriter(String name,List<String> lines) {
		ArgumentChecks.isTrue(name!=null && !name.isEmpty());
		ArgumentChecks.isTrue(lines!=null);
	}

}
