package uo.mp.minesweeper.ranking.utiles.parse;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uo.mp.minesweeper.exception.InvalidLineFormat;
import uo.mp.minesweeper.ranking.GameRankingEntry;
import uo.mp.minesweeper.session.GameLevel;
import uo.mp.minesweeper.util.check.ArgumentChecks;
import uo.mp.minesweeper.util.log.FileLogger;

public class Parse {

	private static final int LENGTHNUMBER = 6;

	
	/**
	 * Recibe una lista de objetos GameRankingEntry y las parsea
	 * @param lines
	 * @return a list, que contiene string con la informacion de los objetos
	 */
	public List<GameRankingEntry> parse(List<String> lines) {
		ArgumentChecks.isTrue(lines!=null,"nombre invalido");
		return parseLines(lines);
	}

	/**
	 * Parsea las lineas a objetos de tipo GameRankingEntry
	 * @return list with GameRankingEntry objects
	 */
	private List<GameRankingEntry> parseLines(List<String> lines) {
		List<GameRankingEntry> result = new ArrayList<>();
		for(String line:lines) {
			try {
				result.add(parseLine(line));
			} catch (InvalidLineFormat e) {
				new FileLogger("minesweeper.log").log(e);
			}
		}
		return result;
	}

	/**
	 * Parsea una linea a objeto GameRankingEntry
	 * @param line
	 * @return a GameRankingEntry object
	 * @throws InvalidLineFormat 
	 */
	private GameRankingEntry parseLine(String line) throws InvalidLineFormat {
		String[] result = line.split(";");
		checkLength(result);
		return new GameRankingEntry(validateUsername(result[0]),toGameLevel(result[3]), 
				toDoubleTime(result[5]), toBooleanVictory(result[4]),toDate(result[1],result[2]));
	}

	private String validateUsername(String name) throws InvalidLineFormat {
		if(!name.toLowerCase().equals(name)) 
		{
			throw new InvalidLineFormat("No se permiten nombres en mayusculas");
		}else {
			return name;
		}
	}

	private Date toDate(String string, String string2) throws InvalidLineFormat {
		String str= string + " " +string2;
		try {
			return new SimpleDateFormat("dd/MM/yy HH:mm").parse(str);
		} catch (ParseException e) {
			throw new InvalidLineFormat("Se ha producido un erro al parsear la linea");
		}
	}

	private boolean toBooleanVictory(String string) throws InvalidLineFormat {
		switch(string) {
		case GameRankingEntry.VICTORIA:
			return true;
		case GameRankingEntry.DERROTA:
			return false;
		default:
			throw new InvalidLineFormat("Error al parsear el resultado");
		}
	}

	/**
	 * Retorna el double asociado a la String
	 * @param string
	 * @return double value
	 */
	private long toDoubleTime(String string) {
		return (long) Double.parseDouble(string);
	}

	/**
	 * Obtiene el enum asociado la dificultad
	 * @param string
	 * @return GameLevel
	 * @throws InvalidLineFormat 
	 */
	private GameLevel toGameLevel(String string) throws InvalidLineFormat {
		switch(string) {
		case "EASY":
			return GameLevel.EASY;
		case "MEDIUM":
			return GameLevel.MEDIUM;
		case "HARD":
			return GameLevel.HARD;
		default:
			throw new InvalidLineFormat("Dificultad del juego invalida");
		}
	}

	/**
	 * Comprueba que la cadena tine los campos necesarios para realizar su parse
	 * @param result.length!
	 * @throws InvalidLineFormat 
	 */
	private void checkLength(String[] result) throws InvalidLineFormat {
		if(result.length!=LENGTHNUMBER) {
			throw new InvalidLineFormat("Campos invalidos");
		}
		
	}
}
