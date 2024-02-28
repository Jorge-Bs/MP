package uo.mp.util.file;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 * A utility class to read/write text lines from/to a text file
 */
public class FileUtil extends FileProccessor{

	public List<String> readLines(String inFIleName) throws FileNotFoundException{
		BufferedReader in = new BufferedReader(new FileReader(inFIleName));
		return super.readLines(in);
	}
	
	public void writeLines(String outFileName, List<String> lines)  {
		BufferedWriter wr;
		try {
			wr = new BufferedWriter(new FileWriter(outFileName));
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		super.writeLines(wr, lines);
	}
	

}
