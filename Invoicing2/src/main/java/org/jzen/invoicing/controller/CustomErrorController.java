package org.jzen.invoicing.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
//import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomErrorController implements ErrorController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);
	
	
	 @RequestMapping(value="/error", method = RequestMethod.GET)
	    public String handleError(HttpServletRequest request) {
		 Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	     
		    if (status != null) {
		        Integer statusCode = Integer.valueOf(status.toString());
		     
		        if(statusCode == HttpStatus.NOT_FOUND.value()) {
		            return "error";
		        }
		        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
		            return "error";
		        }
		        
		        
		    }
		    return "error";
		    
	 }
	 
	 @RequestMapping(value="/error", method = RequestMethod.POST)
	    public String handleErrorPost(HttpServletRequest request) {
		 Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
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
	            
	           
	        }

		    if (status != null) {
		        Integer statusCode = Integer.valueOf(status.toString());
		     
		        if(statusCode == HttpStatus.NOT_FOUND.value()) {
		            return "error";
		        }
		        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
		            return "error";
		        }
		        
		        
		    }
		    return "error";
		    
	 }
	 
	    @Override
	    public String getErrorPath() {
	        return "/error";
	    }
}
