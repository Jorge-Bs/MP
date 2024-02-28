package uo.mp.transaction.model.exception;

public class RepeatedTransactionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepeatedTransactionException(String message) {
		super(message);
	}
}
