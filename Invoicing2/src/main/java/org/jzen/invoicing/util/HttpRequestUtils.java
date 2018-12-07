package org.jzen.invoicing.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;


import org.jzen.invoicing.controller.CurrentInvociesController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpRequestUtils {

	private static final Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class);

    private HttpRequestUtils() {
    }
    
    public static final void showParameters(HttpServletRequest request) {

      try {
       Enumeration enumer = request.getParameterNames();
        while (enumer.hasMoreElements()) {
          String name = (String)enumer.nextElement();
          logger.debug("Parameter Name="+name);
          String values[] =request.getParameterValues(name);
          if (values != null) {
            for (int i=0;i<values.length;i++) {
              logger.debug("Parameter name="+name+"  Parameter Value"+i+" = "+values[i]);
            }
          }
        }
      } catch (Exception e) {
    	 
      }
    }      
    
    
    public static Map getParameters(HttpServletRequest request) {
        final Map map = new HashMap();        
        final Enumeration e = request.getParameterNames();
        
        while (e.hasMoreElements()) {
            final String name = (String)e.nextElement();
            final String[] value = request.getParameterValues(name);
            
            if (logger.isDebugEnabled()) {
            	logger.debug("getParameters(request): key="+name+" ;value="+value+" ;valueClass="+value.getClass());
            	for (String itemVal:value){
            		logger.debug("itemVal="+itemVal);
            	}
            }
            
            map.put(name,value);
        }
        return map;        
    }    
    
    
    public static Map parseQueryString(String s) {
                
        if (s == null) {
            throw new IllegalArgumentException();
        }
        Map ht = new HashMap();
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(s, "&");
        while (st.hasMoreTokens()) {
            String pair = (String)st.nextToken();
            int pos = pair.indexOf('=');
            if (pos == -1) {
                // XXX
                // should give more detail about the illegal argument
                throw new IllegalArgumentException();
            }
            String key = parseName(pair.substring(0, pos), sb);
            String val = parseName(pair.substring(pos+1, pair.length()), sb);
            
            ht.put(key, val);
        }
        return ht;
    }

    /*
     * Parse a name in the query string.
     */

    private static String parseName(String s, StringBuffer sb) {
        sb.setLength(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            switch (c) {
            case '+':
                sb.append(' ');
                break;
            case '%':
                try {
                    sb.append((char) Integer.parseInt(s.substring(i+1, i+3), 
                                                      16));
                    i += 2;
                } catch (NumberFormatException e) {
                    // XXX
                    // need to be more specific about illegal arg
                    throw new IllegalArgumentException();
                } catch (StringIndexOutOfBoundsException e) {
                    String rest  = s.substring(i);
                    sb.append(rest);
                    if (rest.length()==2)
                        i++;
                }
                
                break;
            default:
                sb.append(c);
                break;
            }
        }
        return sb.toString();
    }    
        
}
