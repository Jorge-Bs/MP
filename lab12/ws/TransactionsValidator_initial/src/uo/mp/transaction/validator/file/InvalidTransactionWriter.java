package uo.mp.transaction.validator.file;


import java.util.List;

import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.validator.serialize.TransactionSerializer;
import uo.mp.util.file.FileUtil;

public class InvalidTransactionWriter {

	private String fileName;

	public InvalidTransactionWriter(String fileName) {
		this.fileName = fileName;
	}

	public void save(List<Transaction> invalidTrx) {
		List<String> lines = new TransactionSerializer().serialize( invalidTrx );
		new FileUtil().writeLines(fileName + ".invalid.trx",lines );
	}

}
