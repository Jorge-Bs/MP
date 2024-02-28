package uo.mp.minesweeper.ranking;

import java.util.ArrayList;
import java.util.List;


import uo.mp.minesweeper.util.check.ArgumentChecks;

public class GameRanking {

	private List<GameRankingEntry> result = new ArrayList<>();
	
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
		return copy;
	}
	
	/**
	 * Valida si hay un usuario en el ranking con el username dado como parametro
	 * @param username de tipo String
	 * @return true si lo hay, false en caso contrario
	 */
	public boolean validateUser(String username) {
		if(result.size()==0) {
			return false;
		}else {
			for(GameRankingEntry entry: result) {
				if(entry.getUserName().equals(username)) {
					return true;
				}
			}
			return false;
		}
	}
	
	
}
