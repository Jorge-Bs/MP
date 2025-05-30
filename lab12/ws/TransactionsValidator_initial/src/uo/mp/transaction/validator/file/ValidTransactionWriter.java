package uo.mp.transaction.validator.file;


import java.io.FileNotFoundException;
import java.util.List;

import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.validator.serialize.TransactionSerializer;
import uo.mp.util.file.ZipFileUtil;

public class ValidTransactionWriter {

	private String fileName;

	public ValidTransactionWriter(String fileName) {
		this.fileName = fileName;
	}

	public void save(List<Transaction> validTrx) throws FileNotFoundException {
		List<String> lines = new TransactionSerializer().serialize( validTrx );
		new ZipFileUtil().writeLines(fileName + ".gz",lines );
	}

}
