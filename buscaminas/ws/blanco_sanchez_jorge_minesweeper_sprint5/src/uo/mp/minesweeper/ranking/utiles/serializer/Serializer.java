package uo.mp.minesweeper.ranking.utiles.serializer;

import java.util.ArrayList;
import java.util.List;


import uo.mp.minesweeper.ranking.GameRankingEntry;
import uo.mp.minesweeper.util.check.ArgumentChecks;

public class Serializer {

	
	/**
	 * Realiza la serializacion de objetos y los guarda en un archivo
	 * @param list
	 * @return lines
	 */
	public List<String> serialize(List<GameRankingEntry> list) {
		checkParam(list);
		List<String> lines = serializeList(list);
		return lines;
	}

	/**
	 * Comprueba que los parametro son validos
	 * @param list
	 */
	private void checkParam(List<GameRankingEntry> list) {
		ArgumentChecks.isTrue(list!=null,"La lista no puede ser null");
	}

	/**
	 * Serializa todas las entradas a una lista de Strings
	 * @param list
	 * @return string list
	 */
	private List<String> serializeList(List<GameRankingEntry> list) {
		List<String> lines = new ArrayList<>();
		for(GameRankingEntry line:list) {
			lines.add(line.serialize());
		}
		return lines;
	}
}
