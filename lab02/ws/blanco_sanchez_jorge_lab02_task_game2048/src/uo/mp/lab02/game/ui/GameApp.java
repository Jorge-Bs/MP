package uo.mp.lab02.game.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uo.mp.lab.util.console.Console;
import uo.mp.lab02.game.model.Game2048;

/**
 * <p>
 * Título: Clase principal
 * </p>
 * <p>
 * Descripción: 2048 es un juego en línea creado por Gabriele Cirulli. El
 * objetivo del juego es combinar números juntos (potencias de 2) con el fin de
 * alcanzar el máximo número 2048 y ganar el juego. Para mover los números en el
 * tablero, se debe elegir una dirección (arriba, derecha, abajo o izquierda).
 * Todos los números se mueven en la dirección elegida y pueden ocurrir dos
 * cosas: los números se juntan en una celda que tiene el mismo número o son
 * bloqueados si una celda contiene un número diferente.
 * 
 * <p>
 * Copyright: Copyright (c) 2022
 * </p>
 * <p>
 * Empresa: Escuela de Ingeniería Informática - Universidad de Oviedo
 * </p>
 * 
 * @author Jorge Blanco Sánchez
 * @version 1.0
 */

public class GameApp {
	private Game2048 game;
	
	/**
	 * Ejecuta el juego en bucle mientras el usuario quiera continuar jugando
	 */
	public void run() {
		do {
			play();
		} while (userWantsAnotherPlay());
	}
	
	/**
	 * Instancia la clase Game2048 y será la clase con la que interactua el usuario,
	 * mostrará por pantalla el esatdo del tablero y los movimientos posibles
	 */
	public void play() {

		game = new Game2048();

		showTitle();
		game.restart();
		do {
			System.out.println(game.toString());
			System.out.print("Elige una dirección [r R]/[l L]/[u U]/[d D]: ");
			switch (Console.readCharacter()) {
			case 'r':
			case 'R':
				game.moveRight();
				game.next();
				break;
			case 'l':
			case 'L':
				game.moveLeft();
				game.next();
				break;
			case 'u':
			case 'U':
				game.moveUp();
				game.next();
				break;
			case 'd':
			case 'D':
				game.moveDown();
				game.next();
				break;
			}

		} while (!game.isFinished());

		showGameOver();
	}

	/**
	 * Muestra el título del juego
	 */
	private void showTitle() {
		System.out.print("2048 GAME\n");
	}

	/**
	 * Muestra final del juego
	 */
	private void showGameOver() {
		System.out.println("GAME OVER");
	}

	/**
	 * Pregunta al usuario si quiere continuar
	 * @return true true quiere continuar y false en caso contrario
	 */
	private boolean userWantsAnotherPlay() {
		System.out.print("¿Quieres continuar? s/n: ");
		return  Console.readCharacter()== 's';
	}

	
}
