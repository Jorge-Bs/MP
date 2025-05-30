package uo.mp.lab02.analyzer.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uo.mp.lab02.analyzer.model.WordAnalyzer;

/**
 * Aplication que muestra diferentes operaciones con cadenas de caracteres
 */
public class Application {
	
		
	/**
	 * Pide una palabra al usuario y la analiza
	 */
	public void run() {
		System.out.print("Escribe una palabra: ");
		String word = readString();
		WordAnalyzer analyzer = new WordAnalyzer(word);
		System.out.println("Primer car�cter repetido: " //repetido consecutio		
		                    + analyzer.firstRepeatedCharacter());
		System.out.println("Primer car�cter m�ltiple: "//repetido no consecutivo
		                    + analyzer.firstMultipleCharacter());
		System.out.println("Grupos de caracteres repetidos: " 		
		                    + analyzer.countGroupsOfRepeatedCharacters());			
	}
	
	/**
	 * Lee un string de la consola.
	 * Este codigo NO DEBE ENTERDERSE AHORA se ver� m�s adelante (tema 7).
	 * @return El string escrito por el usuario
	 */
	private String readString() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		try {
		  str = br.readLine();
		}
		catch(IOException e) {
			System.err.println("Error reading the string.");
			System.exit(1);
		}
		return str;
	}

}