package org.jzen.invoicing.util.csv;

public class BadQuoteException extends IllegalArgumentException {

	public BadQuoteException(){
		super();
	}


	public BadQuoteException(String s){
		super(s);
	}

}
