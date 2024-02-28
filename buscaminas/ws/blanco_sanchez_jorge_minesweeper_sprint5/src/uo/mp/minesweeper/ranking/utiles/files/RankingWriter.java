package uo.mp.minesweeper.ranking.utiles.files;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;



import uo.mp.minesweeper.ranking.GameRankingEntry;

public class RankingWriter {
	
	/**
	 * Guarda la lista de ranking en el archivo
	 * @throws FileNotFoundException 
	 */
	public void saveRanking(String file, List<GameRankingEntry> entries) throws FileNotFoundException {
		ObjectOutputStream writer = createWriter(file);;
		writer(entries, writer);
	}

	/**
	 * Eecribe en el fichero la lista de objetos
	 * @param entries
	 * @param writer
	 */
	private void writer(List<GameRankingEntry> entries, ObjectOutputStream writer) {
		try {
			try {
				writer.writeObject(entries);
			}finally {
				writer.close();
			}
		}catch(IOException e) {
			throw new RuntimeException("Ha ocurrido un problema al guardar el ranking");
		}
	}

	/**
	 * Crea el objectWriter
	 * @param file
	 * @return new objectOuptStream
	 * @throws FileNotFoundException 
	 */
	private ObjectOutputStream createWriter(String file) throws FileNotFoundException {
		try {
			return new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw new RuntimeException("se ha producido un erroe con la escritura del archivo");
		}
	}
}
