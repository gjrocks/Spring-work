package org.jzen.invoicing.validator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.PropertyUtils;

public class InvoiceDateRunPeriodValidator implements ConstraintValidator< InvoiceDateRunPeriodConstraints, Object> {
	private String endDate;
    private String prevEndDate;
	
	@Override
	public void initialize(InvoiceDateRunPeriodConstraints dateRange) {
		 this.endDate = dateRange.start();
	     this.prevEndDate = dateRange.end();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		
		
		
		 try {
	            final Object endDateObj = PropertyUtils.getProperty(value, this.endDate);
	            final Object prevEndDateObj = PropertyUtils.getProperty(value, this.prevEndDate);
	            
	            Date endDateVal=new SimpleDateFormat("dd/MM/yyyy").parse((String) endDateObj);  
	            Date prevEndDateVal=new SimpleDateFormat("dd/MM/yyyy").parse((String) prevEndDateObj);  
	           
	            Calendar cal = Calendar.getInstance();
	    		cal.setTime(prevEndDateVal);
	    		cal.add(Calendar.DATE, 10);
	    	
	            return endDateVal.compareTo(cal.getTime())<0;
	             
	          
	        } catch (final Exception ex) {
	        
	            return false;
	        }
	
	}
}
