package org.jzen.invoicing.util.csv;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;


import org.springframework.util.StringUtils;

public class CsvWriter {
	

	/**
	 * Default state of auto flush
	 */
	private static final boolean AUTO_FLUSH = true;

	/**
	 * If auto flushing is enabled.
	 *	 
	 */
	protected boolean autoFlush = AUTO_FLUSH;

	/**
	 * Default state of always quote
	 */
	private static final boolean ALWAYS_QUOTE = false;

	/**
	 * If auto flushing is enabled.
	 *	 
	 */
	protected boolean alwaysQuote = ALWAYS_QUOTE;

	/**
	 * true if an error has occurred.
	 *	 
	 */
	protected boolean error = false;

	/**
	 * Default delimiter character
	 */
	private static final char DELIMITER = ',';

	/**
	 * Character written as field delimiter.
	 *	 
	 */
	protected char delimiterChar = DELIMITER;

	/**
	 * Default quoting character
	 */
	private static final char QUOTE = '"';

	/**
	 * Quoting character.
	 *	 
	 */
	protected char quoteChar = QUOTE;

	/**
	 * The place that the values get written.
	 *
	 */
	protected Writer out;

	/**
	 * True if we just began a new line.
	 */
	protected boolean newLine = true;

	/**
	 * Line ending default
	 */
	private static final String LINE_ENDING_DEFAULT = "\n";

	/**
	 * Line ending indicating the system line ending should be chosen
	 */
	private static final String LINE_ENDING_SYSTEM = null;

	/**
	 * The line ending, must be one of "\n", "\r", or "\r\n"
	 *
	 */
	protected String lineEnding = "\n";



	public CsvWriter(OutputStream out){
		this (
			new OutputStreamWriter(out)
		);
	}


	public CsvWriter(Writer out){
		this(
			out,
                        QUOTE,
                        DELIMITER,   
                        LINE_ENDING_SYSTEM,
			ALWAYS_QUOTE,
			AUTO_FLUSH
		);
	}




	/**
	 *
	 * @param out stream to which to print.
	 * @param delimiter The new delimiter character to use.
	 * @param quote The new character to use for quoting.
	 * @param lineEnding The new line ending, or null to use the default line ending.
	 * @param alwaysQuote true if quotes should be used even when not strictly needed.
	 * @param autoFlush should auto flushing be enabled.
	 * @throws BadQuoteException if the character cannot be used as a quote.
	 * @throws BadDelimiterException if the character cannot be used as a delimiter.
	 * @throws BadLineEndingException if the line ending is not one of the three legal line endings.
	 *	 
	 */
	public CsvWriter(Writer out, char quote, char delimiter, String lineEnding, boolean alwaysQuote, boolean autoFlush) throws BadDelimiterException, BadQuoteException, BadLineEndingException {
		this.out = out;
		changeQuote(quote);
		changeDelimiter(delimiter);
		this.alwaysQuote = alwaysQuote;
		this.autoFlush = autoFlush;
		setLineEnding(lineEnding);
	}

	/**
	 * Change this printer so that it uses a new delimiter.
	 *
	 * @param newDelimiter The new delimiter character to use.
	 * @throws BadDelimiterException if the character cannot be used as a delimiter.
	 *
	 */
	public void changeDelimiter(char newDelimiter) throws BadDelimiterException {
		if (delimiterChar == newDelimiter) return; // no need to do anything.
		if (newDelimiter == '\n' || newDelimiter == '\r' ||
				newDelimiter == delimiterChar || newDelimiter == quoteChar){
			throw new BadDelimiterException();
		}
		delimiterChar = newDelimiter;
	}

	/**
	 * Change this printer so that it uses a new character for quoting.
	 *
	 * @param newQuote The new character to use for quoting.
	 * @throws BadQuoteException if the character cannot be used as a quote.
	 *
	 */
	public void changeQuote(char newQuote) throws BadQuoteException {
		if (quoteChar == newQuote) return; // no need to do anything.
		if (newQuote == '\n' || newQuote == '\r' ||
				newQuote == delimiterChar || newQuote == quoteChar){
			throw new BadQuoteException();
		}
		quoteChar = newQuote;
	}

	/**
	 * A line ending must be one of "\n", "\r", or "\r\n".
	 *
	 * @param lineEnding The new line ending, or null to use the default line ending.
	 * @throws BadLineEndingException if the line ending is not one of the three legal line endings.
	 *
	 */
	public void setLineEnding(String lineEnding) throws BadLineEndingException {
		boolean setDefault = lineEnding == null;
		if (setDefault){
			lineEnding = System.getProperty("line.separator");
		}
		if (!"\n".equals(lineEnding) && !"\r".equals(lineEnding) && !"\r\n".equals(lineEnding)){
			if (setDefault){
				lineEnding = LINE_ENDING_DEFAULT;
			} else {
				throw new BadLineEndingException();
			}
		}
		this.lineEnding = lineEnding;
	}


	public void writeln() throws IOException {
		try {
			out.write(lineEnding);
			if (autoFlush) flush();
			newLine = true;
		} catch (IOException iox){
			error = true;
			throw iox;
		}
	}



	public void writeln(String[] values) throws IOException {
		try {
                        for (int i=0; i<values.length; i++){
                                write(values[i]);
                        }
			writeln();
		} catch (IOException iox){
			error = true;
			throw iox;
		}
	}



	public void write(String value) throws IOException {
		try {
			if (value == null) value = "";
			boolean quote = false;
			if (alwaysQuote){
				quote = true;
			} else if (value.length() > 0){
				for (int i=0; i<value.length(); i++){
					char c = value.charAt(i);
					if (c==quoteChar || c==delimiterChar || c=='\n' || c=='\r'){
						quote = true;
					}
				}
			} else if (newLine) {
				// always quote an empty token that is the first
				// on the line, as it may be the only thing on the
				// line.
				quote = true;
			}
			if (newLine){
				newLine = false;
			} else {
				out.write(delimiterChar);
			}
			if (quote){
				out.write(escapeAndQuote(value));
			} else {
				out.write(value);
			}
			if (autoFlush) flush();
		} catch (IOException iox){
			error = true;
			throw iox;
		}
	}

	/**
	 * Enclose the value in quotes and escape the quote
	 * and comma characters that are inside.
	 */
	private String escapeAndQuote(String value){
		String s = StringUtils.replace(value, String.valueOf(quoteChar), String.valueOf(quoteChar) + String.valueOf(quoteChar));
		return (new StringBuffer(2 + s.length())).append(quoteChar).append(s).append(quoteChar).toString();
	}


	public void flush() throws IOException {
		out.flush();
	}


	public void close() throws IOException {
		out.close();
	}

	/**
	 * Flush the stream if it's not closed and check its error state.
	 * Errors are cumulative; once the stream encounters an error,
	 * this routine will return true on all successive calls.
	 *
	 * @return True if the print stream has encountered an error,
	 * either on the underlying output stream or during a format conversion.
	 *	 
	 */
	public boolean checkError(){
		try {
			if (error) return true;
			flush();
			if (error) return true;
			if (out instanceof PrintWriter){
				error = ((PrintWriter)out).checkError();
			}
		} catch (IOException iox){
			error = true;
		}
		return error;
	}

}
