package org.jzen.invoicing.util.csv;

public class BadDelimiterException extends IllegalArgumentException {

	/**
	 * Constructs an exception with null as its error detail message.
	 *	 
	 */
	public BadDelimiterException(){
		super();
	}

	public BadDelimiterException(String s){
		super(s);
	}

}
