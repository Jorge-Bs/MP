package uo.mp.minesweeper.session;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import uo.mp.minesweeper.exception.GameException;
import uo.mp.minesweeper.exception.UserInteractionException;
import uo.mp.minesweeper.game.Board;
import uo.mp.minesweeper.game.Game;
import uo.mp.minesweeper.game.GameInteractor;
import uo.mp.minesweeper.ranking.GameRanking;
import uo.mp.minesweeper.ranking.GameRankingEntry;
import uo.mp.minesweeper.util.check.ArgumentChecks;
import uo.mp.minesweeper.util.log.SimpleLogger;

public class GameSession {

	private  GameInteractor gameInt;
	private SessionInteractor sessionInt;
	private SimpleLogger logger;
	private GameRanking ranking;
	private String userName;
	private GameLevel level;
	
	
	/**
	 * Establece el gameInteractor de la partida
	 * @param gameInteractor
	 */
	public void setGameInteractor(GameInteractor gameInteractor) {
			this.gameInt = gameInteractor;
	}

	/**
	 * Establece el sessionInteractor
	 * @param sessionInteractor
	 */
	public void setSessionInteractor(SessionInteractor sessionInteractor) {
		this.sessionInt = sessionInteractor;
	}

	/**
	 * Establece el logger de la sesion
	 * @param logger
	 */
	public void setLogger(SimpleLogger logger) {
		this.logger = logger;
	}
	
	/**
	 * Establece el ranking de la session
	 * @param ranking
	 */
	public void setGameRanking(GameRanking ranking) {
		this.ranking = ranking;
	}
	
	/**
	 * Lanza el menu con toda la logica de GameSession
	 */
	public void run() {
		try {
			loadRanking();
			setUserName();
			menu();
			despedida();
		}catch(IllegalArgumentException | IllegalStateException e) {
			sessionInt.showFatalErrorMessage(e.getMessage());
			logger.log(e);
		}catch(RuntimeException e) {
			logger.log(e);
			sessionInt.showFatalErrorMessage(e.getMessage());
		}
	}

	/**
	 * Carga el ranking guardado
	 * @throws IOException 
	 */
	private void loadRanking() {
		try {
			ranking.loadRanking();
		} catch (FileNotFoundException e) {
			logger.log(e);
			sessionInt.showErrorMessage(e.getMessage());
		}
	}

	/**
	 * Establece el nombre del usuario
	 * @param userName
	 */
	private void setUserName() {
		try {
			String name=sessionInt.askUsername();
			checkName(name);
			userName= name;
		}catch (GameException e) {
			sessionInt.showErrorMessage(e.getMessage());
			setUserName();
		}
		
	}
	
	
	/**
	 * Mientras que el usuario no decida salir, se desplegara este menu
	 * @throws IOException 
	 * 
	 */
	private void menu(){
		int value=-1;
		do {
			try {
				value = sessionInt.askNextOption();
				option(value);
			}catch(UserInteractionException | FileNotFoundException e) {
				sessionInt.showErrorMessage(e.getMessage());
				logger.log(e);
			}catch(GameException e) {
				sessionInt.showErrorMessage(e.getMessage());
			}
		}while(value!=0);
	}
	
	/**
	 * Realiza la opcion introducida por el usuario
	 * @param value, opcion a realizar
	 * @throws UserInteractionException 
	 * @throws GameException 
	 */
	private void option(int value) throws UserInteractionException, GameException, FileNotFoundException {
		ArgumentChecks.isTrue(value>=0,"valor invalido");
		switch(value) {
		case 0:
			break;
		case 1:
			createGame();
			break;
		case 2:
			showPersonalRanking();
			break;
		case 3:
			showRanking();
			break;
		case 4:
			exportResult();
			break;
		case 5:
			importResult();
			break;
		default:
			throw new UserInteractionException("Opcion no disponible, vuelva a intentarlo");
			}
	}
	
	
	private void importResult() throws FileNotFoundException {
		String file = sessionInt.askFileName();
		ranking.importRanking(file);
	}

	/**
	 * Exporta el ranking el ranking de un fichero dado por el usuaru
	 */
	private void exportResult() {
		String file = sessionInt.askFileName();
		ranking.exportRanking(file);
		
	}

	/**
	 * Comprueba si el nombre es valido, si no lo es, lanza un IllegalArgumetnException
	 * @throws UserInteractionException
	 */
	private void checkName(String name) throws GameException{
		if(!name.toLowerCase().equals(name)) 
		{
			throw new GameException("No se permiten nombres en mayusculas");
		}
	}
	
	
	/**
	 * Crea una partida del juego con la dificultadad dada como parametro
	 * @throws UserInteractionException 
	 * 
	 */
	private void createGame() throws UserInteractionException, FileNotFoundException {
		level = sessionInt.askGameLevel();
		Game game;
		switch(level) {
		case EASY:
			game = new Game(new Board(9, 9, 12));
			launchGame(game);
			break;
		case MEDIUM:
			game = new Game(new Board(16, 16, 15));
			launchGame(game);
			break;
		case HARD:
			game = new Game(new Board(30, 16, 20));
			launchGame(game);
			break;
		}
	}
	
	
	/**
	 * Lanza el juego 
	 * @param juego a lanzar
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private void launchGame(Game game) throws FileNotFoundException{
		game.setInteractor(gameInt);
		Game result = game.play();
		if(result.hasWon()) {
			saveGame(result);
		}
	}
	
	/**
	 * Registra la partida si el usuario lo desea
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private void saveGame(Game game) throws FileNotFoundException{
		try {
			if(sessionInt.doYouWantToRegisterYourScore()) {
				GameRankingEntry entry = new  GameRankingEntry(this.userName, level, game.getDuration(),true);
				ranking.append(entry);
				ranking.saveRanking();
			}
		}catch(UserInteractionException e) {
			logger.log(e);
			sessionInt.showErrorMessage(e.getMessage());
		}
		
	}
	
	

	/**
	 * Busca todos los ranking asociados al usuario activo
	 * @throws GameException 
	 * 
	 */
	private void showPersonalRanking() throws GameException {
		List<GameRankingEntry> lista = ranking.getEntriesForUserName(this.userName);
		sessionInt.showPersonalRanking(lista);
	}
	
	/**
	 * Solicita todos los rankings disponibles
	 * @throws GameException 
	 */
	private void showRanking() throws GameException {
		List<GameRankingEntry> lista = ranking.getAllEntries();
		sessionInt.showRanking(lista);
	}
	
	/**
	 * Imprime la despedida
	 */
	private void despedida() {
		sessionInt.showGoodBye();
	}
		

	
	
}
