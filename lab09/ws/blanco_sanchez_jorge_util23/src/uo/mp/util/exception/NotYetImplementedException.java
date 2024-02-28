package uo.mp.util.exception;

public class NotYetImplementedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MESSAGE = "Not yet implemented ";

	
	public NotYetImplementedException() {
		super();
	}

	public NotYetImplementedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(DEFAULT_MESSAGE, cause, enableSuppression, writableStackTrace);
	}

	public NotYetImplementedException(String message, Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}

	public NotYetImplementedException(String message) {
		super(DEFAULT_MESSAGE);
	}

	public NotYetImplementedException(Throwable cause) {
		super(cause);
	}
	
	

}
