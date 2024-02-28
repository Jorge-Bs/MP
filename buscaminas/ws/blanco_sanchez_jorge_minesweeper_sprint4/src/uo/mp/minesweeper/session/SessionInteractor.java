package uo.mp.minesweeper.session;

import java.util.List;

import uo.mp.minesweeper.exception.GameException;
import uo.mp.minesweeper.exception.UserInteractionException;
import uo.mp.minesweeper.ranking.GameRankingEntry;

public interface SessionInteractor {

	/**
	 * Solicita al usuario un nivel de dificultadad y devuelve la respuesta con un
	 * GameLevel
	 * @return difficulty status, los valores que tiene que devolver son
	 * 			-EASY
	 * 			-MEDIUM
	 * 			-HARD
	 */
	GameLevel askGameLevel();
	
	/**
	 * Asks the user a name and return the input value
	 * @return userName
	 * @throws GameException 
	 */
	String askUsername() throws GameException;
	
	/**
	 * Solicita al usuario que introduzaca una opcion del menu
	 * @return option
	 */
	int askNextOption() throws UserInteractionException;
	
	/**
	 * Si el usuario ha ganado, se le pregunta si quiere registra su victoria en el marcador
	 * @return true si quiere registrar su partida, false en caso contrario
	 */
	boolean doYouWantToRegisterYourScore();
	
	/**
	 * Recibe una lista de objetos GameRankingEntry representando todas las puntuaciones
	 * @param ranking
	 */
	void showRanking(List<GameRankingEntry> ranking) throws GameException;
	
	/**
	 * Recibe una lista de objetos GameRankingEntry, del usuario, representando 
	 * todas sus puntuaciones, se omite su userName
	 * @param ranking
	 */
	void showPersonalRanking(List<GameRankingEntry> ranking) throws GameException;
	
	
	/**
	 * Muestra al usuario un mensaje de despedida cuando eliga la opcion exit
	 */
	void showGoodBye();
	
	/**
	 * Muestra el error por pantalla
	 * @param message
	 */
	public void showErrorMessage(String message);
	
	/**
	 * Comunica mensajes de error graves al usuario, 
	 * solo para aquellos errores que no se pueden corregir
	 * @param message
	 */
	void showFatalErrorMessage(String message);
}

