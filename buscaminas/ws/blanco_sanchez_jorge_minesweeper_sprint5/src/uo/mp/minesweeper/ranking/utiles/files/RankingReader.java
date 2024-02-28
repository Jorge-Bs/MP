package uo.mp.minesweeper.ranking.utiles.files;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import uo.mp.minesweeper.ranking.GameRankingEntry;

public class RankingReader {

	/**
	 * Carga la lista de rankings del archivo
	 * @return a list with gameRankingEntries
	 * @throws FileNotFoundException
	 */
	public List<GameRankingEntry> loadRanking(String file) throws FileNotFoundException {
		ObjectInputStream in = createReader(file);
		return reader(in);
		
	}

	/**
	 * Crea el ObjectInputStream 
	 * @param file
	 * @return an ObjectInputStream
	 * @throws FileNotFoundException
	 */
	private ObjectInputStream createReader(String file) throws FileNotFoundException {
		try {
			return new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw new RuntimeException("se ha producido un erroe con la lectura del archivo");
		}
	}

	/**
	 * Lee los objetos del archivo y los devuelve
	 * @param in
	 * @param result
	 * @return lista de los objetos leidos
	 */
	private List<GameRankingEntry> reader(ObjectInputStream in){
		List<GameRankingEntry> result;
		try {
			try {
				result=setResult(in.readObject());
			}finally {
				in.close();
			}
		}catch(IOException |ClassNotFoundException e) {
			throw new RuntimeException("Se ha producido un error al cargar el ranking");
		}
		return result;
	}

	/**
	 * Realiza un cast a los objetos del archivo y los devuelve
	 * @param result
	 * @return list with gameRankingEntries
	 */
	@SuppressWarnings("unchecked")
	private List<GameRankingEntry> setResult(Object result) {
		return (List<GameRankingEntry>) result;
	}
	
	
	
}
