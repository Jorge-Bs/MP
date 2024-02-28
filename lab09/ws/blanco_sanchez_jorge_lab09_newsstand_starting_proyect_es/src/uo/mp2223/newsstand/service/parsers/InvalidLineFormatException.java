package uo.mp2223.newsstand.service.parsers;


import uo.mp.util.check.ArgumentChecks;

public class InvalidLineFormatException extends Exception{
	private static final long serialVersionUID = 1L;
	
	private int lineNumber;

	public InvalidLineFormatException(int lineNumber,String msg) {
		super(msg);
		ArgumentChecks.isTrue(lineNumber>0);
		this.lineNumber= lineNumber;
	}
	
	@Override
	public String getMessage() {
		return "INVALID LINE " + lineNumber +" " +super.getMessage();
	}
}
