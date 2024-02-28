package uo.mp.transaction.validator.file;

import java.io.FileNotFoundException;
import java.util.List;

import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.model.exception.RepeatedTransactionException;
import uo.mp.transaction.validator.parser.TransactionParser;
import uo.mp.util.file.FileUtil;

public class TransactionLoader {

	private String fileName;

	public TransactionLoader(String fileName) {
		this.fileName = fileName;
	}

	public List<Transaction> load() throws FileNotFoundException, RepeatedTransactionException {
		List<String> lines = new FileUtil().readLines( fileName );
		return new TransactionParser().parse( lines );
	}

}
