package uo.mp.exception.exception;

public class LineFormatException extends Exception {
	private static final long serialVersionUID = 1L;
	private String line;
	private int lineNumber;

	public LineFormatException() {
	}

	public LineFormatException(String arg0) {
		super(arg0);
	}

	public LineFormatException(Throwable arg0) {
		super(arg0);
	}

	public LineFormatException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public LineFormatException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public LineFormatException(String message, String line, int ln) {
		this(message);
		this.line = line;
		this.lineNumber = ln;
	}

	public LineFormatException(String message, String line, int ln, NumberFormatException nfe) {
		this(message, nfe);
		this.line = line;
		this.lineNumber = ln;
	}

	@Override
	public String getMessage() {
		return super.getMessage() + 
				" in line " + 
				lineNumber + 
				" with content " + 
				line;
	} 
	
	

}
