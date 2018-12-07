package org.jzen.invoicing.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;


import org.jzen.invoicing.controller.CurrentInvociesController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class FormatUtils {
	private static final Logger logger = LoggerFactory.getLogger(FormatUtils.class);

	    private FormatUtils() {
	    }

	    public static final String twoDecimalFormat(double value) {
	        NumberFormat nf = NumberFormat.getInstance();
	        nf.setMinimumIntegerDigits(1);
	        nf.setMinimumFractionDigits(2);
	        nf.setMaximumFractionDigits(2);

	        return nf.format(value);
	    }
	    
	    public static final String twoDecimalFormatWithoutGroup(double value) {
	    	//amendLL2011/01: #10392 digits of a thousand number will not grouped, e.g. 1234.56 will not become 1,234.56    	
	        NumberFormat nf = NumberFormat.getInstance();
	        nf.setMinimumIntegerDigits(1);
	        nf.setMinimumFractionDigits(2);
	        nf.setMaximumFractionDigits(2);
	        nf.setGroupingUsed(false);

	        return nf.format(value);
	    }
	    
	    public static final String percentageFormatWithoutGroup(double value) {
	    	//amendLL2011/02: #11575 digits of a thousand number will not grouped, e.g. 1234.56% will not become 1,234.56%    	
	        NumberFormat nf = NumberFormat.getPercentInstance();        
	        nf.setMinimumFractionDigits(2);
	        nf.setMaximumFractionDigits(2);
	        nf.setGroupingUsed(false);       

	        return nf.format(value);
	    }
	    
	    public static final String emptyStringIsNull(String s) {
	        if (StringUtils.hasText(s)) {
	            return s;
	        } else {
	            return null;
	        }
	    }

	    public static final String capitaliseFirstLetter(String value) {
	        if (StringUtils.hasText(value)) {
	        	StringBuilder formattedValue = new StringBuilder();
	            StringTokenizer st = new StringTokenizer(value," ");
	            int count =0;
	            while (st.hasMoreTokens()) {
	                if (count > 0) 
	                	formattedValue.append(" ");

	                String s = st.nextToken();
	                if (s.length()>0) {
	                    formattedValue.append(Character.toUpperCase(s.charAt(0)));
	                }

	                if (s.length()>1) {
	                    formattedValue.append(s.substring(1).toLowerCase());
	                }

	                count++;
	            }
	            return formattedValue.toString();
	        } else {
	            return "";
	        }
	    }

	    public static String upper(String s) {
	        if (StringUtils.hasText(s)) 
	        	return s.trim().toUpperCase();
	        else 
	        	return null;
	    }

	    public static String lower(String s) {
	        if (StringUtils.hasText(s)) 
	        	return s.trim().toLowerCase();
	        else 
	        	return null;
	    }

	    public static String formatNationalInsuranceNo(String s) {

	        if (StringUtils.hasText(s)) {
	            String ni = s.trim();
	            ni = ni.toUpperCase();
	            if (ni.length() == 8) 
	            	ni = ni+" ";
	            
	            return ni;
	        }
	        
	        return null;
	    }

	    public static String convertToHex(byte[] data) {

	        StringBuilder buf = new StringBuilder();
	        
	        for (int i = 0; i < data.length; i++) {
	                int halfbyte = (data[i] >>> 4) & 0x0F;
	                int twoHalves = 0;
	                
	                do {
						if ((0 <= halfbyte) && (halfbyte <= 9))
							buf.append((char) ('0' + halfbyte));
						else
							buf.append((char) ('a' + (halfbyte - 10)));
						
						halfbyte = data[i] & 0x0F;
	                } while(twoHalves++ < 1);
	        }
	        
	        return buf.toString();
	    }


	    public static String stack2string(Exception e) {
	    	  try {
	    	    StringWriter sw = new StringWriter();
	    	    PrintWriter pw = new PrintWriter(sw);
	    	    e.printStackTrace(pw); // NOSONAR
	    	    return "------\r\n" + sw.toString() + "------\r\n";
	    	  } catch(Exception e2) {
	    		  final String msg = "bad stack2string";
	    		  logger.warn(msg, e2);
	    		  return msg;
	    	  }
	    }

	    /** Converts a string to camel case, with each word capitalised
	     *  @param s the string to convert
	     *  @param preserveCase preserve the case of letters other than the first
	     *  @return the converted string
	     */
	    public static String camelCap(String s, boolean preserveCase) {
	        if (s == null || s.length() == 0) {
	            return s;
	        }
	        StringBuilder sb = new StringBuilder();
	        StringTokenizer st = new StringTokenizer(s);
	        while (st.hasMoreTokens()) {
	            if (sb.length() > 0) {
	                sb.append(" ");
	            }
	            String word = st.nextToken();
	            sb.append(word.substring(0, 1).toUpperCase());
	            if ( word.length() > 1) {
	            	if (preserveCase) {
	            		sb.append(word.substring(1));
	            	} else {
	            		sb.append(word.substring(1).toLowerCase());
	            	}               
	            }
	        }
	        return sb.toString();
	    }
	    
	    public static boolean textHasLengthGreaterThan(String text, int length) {
	        return !(text == null || text.trim().length() <= length);
	    }
	    
	    public static boolean textHasLengthLessThan(String text, int length) {
	    	return (text == null) || (text.trim().length() < length);
	    }
	    
		public static Date setToLastDayOfMonth(Date date) {
			if (date != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				int lastDateOfMonth = cal.getActualMaximum(Calendar.DATE);
				cal.set(Calendar.DATE, lastDateOfMonth);
				return cal.getTime();
			}
			return null;
		}

		public static String formatUKPostcode(String postcode){
			
		
			 if (StringUtils.hasText(postcode) && 
		        		(org.apache.commons.lang.StringUtils.length(postcode) > 3)) {
		        		// then it's a not a partial postcode and must have 1 space.
		        	
		        	// How many spaces?
		        	int spaceCount = StringUtils.countOccurrencesOf(postcode, " ");
		        	
		        	// Too many spaces?
			    	if (spaceCount > 1) {
			    		// Strip all spaces and let the code below deal with it:
			    		postcode = StringUtils.trimAllWhitespace(postcode);
			    		spaceCount = 0;
			    	}
			    	
			    	// Need to insert a space?
			    	if (spaceCount == 0) {
			    		final int length = postcode.length();
			            final StringBuilder sb = new StringBuilder(postcode);
			            // a space needs inserting before the last 3 chars
			            sb.insert(length-3," ");
			            postcode = sb.toString();
			    	}
			    	
			    	assert StringUtils.countOccurrencesOf(postcode, " ") == 1;
			    	
			    	
		}
			 return postcode;
		}
}
