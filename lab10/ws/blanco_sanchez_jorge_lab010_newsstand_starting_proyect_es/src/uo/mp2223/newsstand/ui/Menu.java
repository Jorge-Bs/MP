package uo.mp2223.newsstand.ui;

import uo.mp.util.console.Console;

/**
 * Shows the user a menu of options. Each option will be identified 
 * by a sequential number.
 */
public class Menu {
	private String[] options = {
			"Load a file",
			"Show publications",
			"Add publication",
			"Remove publication",
			"Create orders",
			"Save orders to file",
			"Import from zip",
			"Export to zip",
			"Sort by Name",
			"Sort by Sales",
			"Sort by Quantity and Name"
		};
		
	public int readOption() {
		return Console.readInt("Option");
	}

	public void show() {
		int i = 1;
		for(String line: options) {
			if ( "".equals(line) ) {
				Console.print("");
				continue;
			}
			
			Console.print(String.format("\t%2d- %s\n", i++, line)); 
		}
		Console.print(String.format("\n\t%2d- %s\n", 0, "Exit"));
	}

}
