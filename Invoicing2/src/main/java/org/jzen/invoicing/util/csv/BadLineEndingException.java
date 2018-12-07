package org.jzen.invoicing.util.csv;

public class BadLineEndingException extends IllegalArgumentException {


	public BadLineEndingException(){
		super();
	}

	public BadLineEndingException(String s){
		super(s);
	}

}
