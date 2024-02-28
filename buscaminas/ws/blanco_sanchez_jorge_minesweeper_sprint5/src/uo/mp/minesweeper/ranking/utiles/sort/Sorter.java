package uo.mp.minesweeper.ranking.utiles.sort;

import java.util.Comparator;

import uo.mp.minesweeper.ranking.GameRankingEntry;


public class Sorter implements Comparator<GameRankingEntry> {

	
	/**
	 * Compara dos objetos recibidos por parametros
	 * @param o1 primer objeto de tipo GameRankingEntry
	 * @param o2 primer segundo de tipo GameRankingEntry
	 */
	@Override
	public int compare(GameRankingEntry o1, GameRankingEntry o2) {
		int value;
		value = compareLevel(o1,o2);
		value = value==0? compareDuration(o1,o2): value;
		value = value==0? compareDate(o1,o2): value;
		return value;
	}

	/**
	 * Compara la fecha
	 * @param o1
	 * @param o2
	 * @return el resultado de la resta de las fechas
	 */
	private int compareDate(GameRankingEntry o1, GameRankingEntry o2) {
		return o1.getDate().compareTo(o2.getDate());
	}

	/**
	 * Compara los objetos segun la duracion de la partida
	 * @param o1
	 * @param o2
	 * @return value, siendo el resultado el significado de cual de los dos tine que ir antes
	 */
	private int compareDuration(GameRankingEntry o1, GameRankingEntry o2) {
		return (int) (o1.getDuration()-o2.getDuration());
	}

	/**
	 * Compara los objetos segun la dificultad de la partida, siendo preferente una difucultada mayor
	 * @param o1
	 * @param o2
	 * @return un valor, para ordenar en la lista
	 */
	private int compareLevel(GameRankingEntry o1, GameRankingEntry o2) {
		return o1.getLevel().compareTo(o2.getLevel());
	}
}
