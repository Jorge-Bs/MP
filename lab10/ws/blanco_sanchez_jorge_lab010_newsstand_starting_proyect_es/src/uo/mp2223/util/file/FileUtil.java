package uo.mp2223.util.file;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import uo.mp2223.newsstand.service.NewsstandException;

/**
 * A utility class to read/write text lines from/to a text file
 */
public class FileUtil extends FileProccessor{

//	public List<String> readLines(String inFileName) throws NewsstandException {
//		checkName(inFileName);
//		List<String> res = new LinkedList<>();
//		
//		res.add("newspaper	La Nueva España	14	30");
//		res.add("newspaper	El Mundo	4	10"); 
//		res.add("magazine	Hola	14	30	BIMONTHLY"); 
//		res.add("magazine	PCWord	14	30	QUARTERLY");
//		res.add("magazine	Diez Minuntos	4	10	WEEKLY"); 
//		res.add("magazine	El Mueble	4	10	MONTHLY");
//		res.add("magazine	Muy Interesante	8	20	DAILY");
//		res.add("magazine	Quo	8	10	BIMONTHLY");
//		
//		return res;
//	}

	public List<String> readLines(String inFIleName) throws FileNotFoundException, NewsstandException{
		super.validateNameReader(inFIleName);
		BufferedReader in = new BufferedReader(new FileReader(inFIleName));
		return super.readLines(in);
	}
	
	public void writeLines(String outFileName, List<String> lines) throws IOException {
		super.validateParamsWriter(outFileName, lines);
		BufferedWriter wr = new BufferedWriter(new FileWriter(outFileName));
		super.writeLines(outFileName, wr, lines);
	}
	

}
