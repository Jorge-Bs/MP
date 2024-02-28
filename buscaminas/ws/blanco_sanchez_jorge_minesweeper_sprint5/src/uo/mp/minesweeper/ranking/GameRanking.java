package uo.mp.minesweeper.ranking;



import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uo.mp.minesweeper.file.FileUtil;
import uo.mp.minesweeper.ranking.utiles.files.RankingReader;
import uo.mp.minesweeper.ranking.utiles.files.RankingWriter;
import uo.mp.minesweeper.ranking.utiles.parse.Parse;
import uo.mp.minesweeper.ranking.utiles.serializer.Serializer;
import uo.mp.minesweeper.ranking.utiles.sort.Sorter;
import uo.mp.minesweeper.util.check.ArgumentChecks;

public class GameRanking {


	
	private List<GameRankingEntry> result = new ArrayList<>();
	private RankingReader ranRea = new RankingReader();
	private RankingWriter rankWri = new RankingWriter();
	private String filePath;
	
	
	/**
	 * Constructor que recibe el nombre del archivo por parametro, este se  utilizara en el log
	 * @param filePath
	 */
	public GameRanking(String filePath) {
		setFilePath(filePath);
	}
	
	private void setFilePath(String filePath) {
		ArgumentChecks.isTrue(filePath!=null && !filePath.isBlank());
		this.filePath = filePath;
	}

	/**
	 * Añade una entrada a la lista
	 * @param entry
	 */
	public void append(GameRankingEntry entry) {
		ArgumentChecks.isTrue(entry!=null,"entrada invalida");
		result.add(entry);
	}
	
	/**
	 * Devuelve una copia de la lista
	 * @return copia de la lista
	 */
	public List<GameRankingEntry> getAllEntries(){
		List<GameRankingEntry> copy = new ArrayList<>();
		for(GameRankingEntry entry:result) {
			copy.add(entry.clone());
		}
		Collections.sort(copy,new Sorter());
		return copy;
	}
	
	/**
	 * Devuelve una lista con las entradas para el usuario dado como parametro
	 * @param userName
	 * @return list con sus entradas
	 */
	public List<GameRankingEntry> getEntriesForUserName(String userName){
		List<GameRankingEntry> copy = new ArrayList<>();
		for(GameRankingEntry entry:result) {
			if(entry.getUserName().equals(userName)) {
				copy.add(entry.clone());
			}
		}
		Collections.sort(copy, new Sorter());
		return copy;
	}
	
//	/**
//	 * Valida si hay un usuario en el ranking con el username dado como parametro
//	 * @param userName de tipo String
//	 * @return true si lo hay, false en caso contrario
//	 */
//	public boolean validateUser(String username) {
//		if(result.size()==0) {
//			return false;
//		}else {
//			for(GameRankingEntry entry: result) {
//				if(entry.getUserName().equals(username)) {
//					return true;
//				}
//			}
//			return false;
//		}
//	}
	
	
	/**
	 * Carga el ranking
	 * @throws FileNotFoundException
	 */
	public void loadRanking() throws FileNotFoundException {
		try {
			setRanking(ranRea.loadRanking(filePath));
		}catch(FileNotFoundException e) {
			throw new FileNotFoundException("No se ha encotrado nigun archivo para cargar el ranking,"
					+ " este se inicializará sin ninguna entrada");
		}
	}
	
	/**
	 * Guarda el ranking en un fichero, si no lo encuentra crea uno nuevo
	 * @throws FileNotFoundException
	 */
	public void saveRanking() throws FileNotFoundException {
		rankWri.saveRanking(filePath, result);
	}
	
	/**
	 * Importa los resultados del archivo
	 * @param fileName, de tipo String
	 * @throws FileNotFoundException 
	 */
	public void importRanking(String fileName) throws FileNotFoundException {
		List<String> list = new FileUtil().readLines(fileName);
		List<GameRankingEntry> result = new Parse().parse(list);
		setRanking(result);
		saveRanking();
	}
	
	/**
	 * Exporta el ranking
	 * @param fileName
	 */
	public void exportRanking(String fileName) {
		List<String> lines = new Serializer().serialize(result);
		new FileUtil().writeLines(fileName, lines);
	}

	
	/**
	 * Establece el ranking con la lista que se le da por parametro
	 * @param list
	 */
	private void setRanking(List<GameRankingEntry> list) {
		ArgumentChecks.isTrue(list!=null,"lista invalida");
		result=list;
		
	}
	
}
