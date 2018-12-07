package org.jzen.invoicing.datatable;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.jzen.invoicing.util.HttpRequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PagingHelper {

	private static final Logger logger = LoggerFactory.getLogger(PagingHelper.class);

   
    
    
    public static void assignPagingAttributes(PagingData pagingBean,String path,HttpServletRequest request) {
        if (logger.isDebugEnabled()) logger.debug("ActionMapping PATH="+path);
        // this is used by the ajaxPaging to know what request to make in paging
        request.setAttribute("actionPath",path);     
        request.setAttribute(PagingData.NAME, pagingBean); 
        // the parameters of the request converted to a String for easy use in the paging tile
      //  request.setAttribute("pageParams",getPageParams(request));        
    }
    
    public static String getPageParams(HttpServletRequest request) {
    
        Map map = getRequestParameters(request);
        
        if (map == null || map.isEmpty()) {
            logger.debug("createParameterString - map is empty");
            return null;
        }
        
        final Iterator it = map.keySet().iterator();
        
        StringBuffer sb = new StringBuffer();
        
        while (it.hasNext()) {
            final Object name = it.next();
            final Object value = map.get(name);
            
            if ("page".equals(name) && value != null) {
                if (value instanceof String[] ) {
                    String[] vals = (String[])value;
                    for (String val : vals) {
                        addParam(sb,name.toString(),val);
                    }
                } else if (value instanceof String) {
                    addParam(sb,name.toString(),value.toString());
                }
            }
        }       
        return sb.toString();
    }
        
    public static void addParam(StringBuffer param, String name, String value) {
        if (logger.isDebugEnabled()) logger.debug("addParam():"+name+":"+value);
        
        final boolean isQuery = (param.indexOf("?")>=0);

        if (isQuery) param.append("&");
        else param.append("?");

        param.append(name);
        param.append("=");
        param.append(value);
     }      
     
    public static Map getRequestParameters(HttpServletRequest request) {
       return HttpRequestUtils.getParameters(request);
    } 
    
    public static Map getSQLParameters(HttpServletRequest request) {  
        return HttpRequestUtils.getParameters(request);
    }    
    
    

    
}
