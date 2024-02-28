package uo.mp.minesweeper.file;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


/**
 * A utility class to read/write text lines 
 * from/to a compressed text file (.txt.gz) 
 */
public class ZipFileUtil extends FileProccessor {

	public List<String> readLines(String inFileName) throws FileNotFoundException{
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							new GZIPInputStream(
									new FileInputStream(inFileName))));
			return super.readLines(in);
		}catch(FileNotFoundException e) {
			throw e;
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void writeLines(String outZippedFileName, List<String> lines) throws FileNotFoundException, IOException {
		BufferedWriter wr = new BufferedWriter(
				new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(outZippedFileName))));
		
		super.writeLines( wr, lines);
	}
	
}


