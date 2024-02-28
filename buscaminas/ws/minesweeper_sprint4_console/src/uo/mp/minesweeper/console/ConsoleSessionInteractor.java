package uo.mp.minesweeper.console;

import java.util.List;

import uo.mp.lab.minesweeper.console.Console;
import uo.mp.minesweeper.exception.GameException;
import uo.mp.minesweeper.exception.UserInteractionException;
import uo.mp.minesweeper.ranking.GameRankingEntry;
import uo.mp.minesweeper.session.GameLevel;

import uo.mp.minesweeper.session.SessionInteractor;
import uo.mp.minesweeper.util.log.BasicSimpleLogger;
import uo.mp.minesweeper.util.log.SimpleLogger;

public class ConsoleSessionInteractor implements SessionInteractor{
	
	public static final int MIN_MENU_VALUE=0;
	public static final int MAX_MENU_VALUE=3;
	private SimpleLogger logger = new BasicSimpleLogger();
	

	/**
	 * Solicita al usuario un nivel de dificultadad y devuelve la respuesta con un
	 * GameLevel
	 * @return difficulty status, los valores que tiene que devolver son
	 * 			-EASY
	 * 			-MEDIUM
	 * 			-HARD
	 */
	@Override
	public GameLevel askGameLevel() {
		System.out.print("\nDificultad? (e)asy | (m)edium | (h)ard");
		try {
			return createDificulty((char)Console.readCharacter());
		}catch(UserInteractionException e) {
			logger.log(e);
			return askGameLevel();
		}
	}
	
	/**
	 * Comprueba que la opcion introducida por el usuario es valida, si lo es, lo transforma
	 * a un GameLevel, en caso contrario, lanza un UserInteractionException
	 * @param value
	 * @return GameLevel
	 * @throws UserInteractionException
	 */
	private GameLevel createDificulty(char value) throws UserInteractionException {
		switch(value) {
		case 'e': case 'E':
			return GameLevel.EASY;
		case 'm': case 'M':
			return GameLevel.MEDIUM;
		case 'h': case 'H':
			return GameLevel.HARD;
		default:
			throw new UserInteractionException("Opcion introducida no valida, intentalo de nuevo");
		}
	}
	
	/**
	 * Asks the user a name and return the input value
	 * @return userName
	 * @throws GameException 
	 */
	@Override
	public String askUsername() throws GameException {
		System.out.print("\nIntroduzca un nombre de usuario: ");
		String userName= Console.readString();
		validateUserName(userName);
		return userName;
	}
	
	
	/**
	 * Valida si el usuario es correcto y esta disponible
	 * @param userName a  validar
	 * @throws UserInteractionException 
	 * 
	 */
	private void validateUserName(String name) throws GameException {
		if(name == null || name.isBlank() || name.isEmpty()) {
			throw new GameException("Nombre no valido, intentalo de nuevo");}
	}
	
	/**
	 * Solicita al usuario que introduzaca una opcion del menu
	 * @return option
	 * @throws UserInteractionException 
	 */
	@Override
	public int askNextOption(){
		menu();
		int option = Console.readInt();
		return option;
	}
	
	/**
	 * Imprime el menu de opciones
	 */
	private void menu() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nAvailable options:");
		sb.append("\n  1- Play a new game");
		sb.append("\n  2- Show my results");
		sb.append("\n  3- Show all results");
		sb.append("\n  0- Exit");
		sb.append("\noption? ");
		System.out.print(sb);
	}


	/**
	 * Si el usuario ha ganado, se le pregunta si quiere registra su victoria en el marcador
	 * @return true si quiere registrar su partida, false en caso contrario
	 */
	@Override
	public boolean doYouWantToRegisterYourScore() {
		System.out.print("\nDesea registrar su victoria?: (y)es | (n)o ");
		try {
			char option= (char) Console.readCharacter();
			return optionInBoolean(option);
		}catch (UserInteractionException e) {
			logger.log(e);
			return doYouWantToRegisterYourScore();
		}
	}
	/**
	 * Transforma la opcion del usuario en un valor booleano
	 * @param option
	 * @return true, si es y o Y, false, si es n o N
	 * @throws UserInteractionException 
	 */
	private boolean optionInBoolean(char option) throws UserInteractionException {
		switch (option) {
		case 'y': case 'Y':
			return true;
		case 'n': case 'N':
			return false;
		default:
			throw new UserInteractionException("Valor no valido, intentalo de nuevo");
		}
	}


	/**
	 * Recibe una lista de objetos GameRankingEntry representando todas las puntuaciones
	 * @param ranking
	 * @throws GameException 
	 */
	@Override
	public void showRanking(List<GameRankingEntry> ranking) throws GameException {
		listaVacia(ranking.size());
		StringBuilder sb= new StringBuilder();
		sb.append("UserName   Date\t\tHour\tLevel\tResult\tTime(s)\n");
		for(GameRankingEntry entry:ranking) {
			sb.append(entry+"\n");
		}
		print(sb);
	}

	/**
	 * Imprime por pantalla el objeto recivido por paramentro
	 * @param sb
	 */
	private void print(StringBuilder sb) {
		System.out.print("\n"+sb);
	}

	/**
	 * Comprueba que la lista no esta vacia
	 * @param size
	 * @return true si lo esta, false en caso  contrario
	 * @throws GameException 
	 */
	private void listaVacia(int size) throws GameException {
		if(size==0) {
			throw new GameException("El ranking está vacio");
		}
	}

	/**
	 * Recibe una lista de objetos GameRankingEntry, del usuario, representando 
	 * todas sus puntuaciones, se omite su userName
	 * @param ranking
	 * @throws GameException 
	 */
	@Override
	public void showPersonalRanking(List<GameRankingEntry> ranking) throws GameException {
		listaVacia(ranking.size());
		StringBuilder sb = new StringBuilder();
		sb.append("Date\t\tHour\tLevel\tResult\tTime\n");
		for(GameRankingEntry entry:ranking) {
			String line= formatLine(entry.toString());
			sb.append(line+"\n");
		}
		print(sb);
		
	}
	
	/**
	 * Formate la line dada como parametro para la eliminacion del nombre del usuario
	 * presente en dicha linea
	 * @param String a eliminar usuario 
	 * @return String sin el usuario
	 */
	private String formatLine(String line) {
		return line.split(" \t",2)[1];
	}
	

	/**
	 * Muestra al usuario un mensaje de despedida cuando eliga la opcion exit
	 */
	@Override
	public void showGoodBye() {
		System.out.print("\nHasta la proxima");
	}
	
	public void showErrorMessage(String message) {
		System.out.println(message);
	}

	/**
	 * Comunica mensajes de error graves al usuario, 
	 * solo para aquellos errores que no se pueden corregir
	 * @param message
	 */
	@Override
	public void showFatalErrorMessage(String message) {
		System.out.print("\nSe ha producido un error inesperado, la aplicacion será cerrada,"
				+ " intentalo de nuevo mas tarde, si el problema persigue pongase en contacto con"
				+ " el administrador del programa.");
	}

}
