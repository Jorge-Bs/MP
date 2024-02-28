package uo.mp.exception;
import java.util.List;

public class Accounter {
	
	private List<String> lines;

	public Accounter(String fileName) {
		lines = readLinesOnFile(fileName);		
	}
	
	public double processFile() {
		double res = 0.0;
		int ln = 1;
		for (String l : lines) {		
			res += processLine(l, ln++);
		}
		return res;
	}

	private static List<String> readLinesOnFile(String fName) {
		FileReader f = new FileReader(fName); // <-- Puede lanzar FileNotFoundException
		List<String> lines = f.readLines();   // <-- Puede lanzar IOException
		f.close();                            // <-- Puede lanzar IOException
		return lines;
	}

	private static double processLine(String line, int ln) {
		String[] parts = line.split( "\t" );
		
		double amount = Double.parseDouble( parts[ 2 ] );
		
		return amount;
	}

}
