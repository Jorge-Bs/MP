package uo.mp.lab02.game;

import uo.mp.lab02.game.ui.GameApp;
/**
 * Main class
 * 
 * Se encarga de inicializar el juego
 * 
 * @author Jorge Blanco Sánchez
 * @version 11-02-2023
 *
 */
public class Main {

	/**
	 * Método main que llama al método run de la clase GameApp
	 * @param args
	 */
	public static void main(String[] args) {
		new GameApp().run();
	}

}
