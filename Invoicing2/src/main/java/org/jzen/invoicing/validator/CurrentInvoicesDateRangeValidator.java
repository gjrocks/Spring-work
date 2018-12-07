package org.jzen.invoicing.validator;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.PropertyUtils;



public class CurrentInvoicesDateRangeValidator implements ConstraintValidator<DateRangeConstraints, Object> {

	private String fromDate;
    private String toDate;
	
	@Override
	public void initialize(DateRangeConstraints dateRange) {
		 this.fromDate = dateRange.start();
	     this.toDate = dateRange.end();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		
		
		
		 try {
	            final Object fromDateObj = PropertyUtils.getProperty(value, this.fromDate);
	            final Object toDateObj = PropertyUtils.getProperty(value, this.toDate);
	            
	            if(fromDateObj==null|| toDateObj==null || fromDateObj.equals("") || toDateObj.equals("") ) {
	            	return true;
	            }
	            
	            Date fromDateVal=new SimpleDateFormat("dd/MM/yyyy").parse((String) fromDateObj);  
	            Date toDateVal=new SimpleDateFormat("dd/MM/yyyy").parse((String) toDateObj);  
	           
	            return toDateVal.compareTo(fromDateVal)>=0;
	             
	          
	        } catch (final Exception ex) {
	        
	            return false;
	        }
	
	}

}
