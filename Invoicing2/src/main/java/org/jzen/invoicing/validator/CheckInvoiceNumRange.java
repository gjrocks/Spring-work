package org.jzen.invoicing.validator;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.util.StringUtils;

public class CheckInvoiceNumRange implements ConstraintValidator<CheckInvoiceNumRangeConstraint, Object>{
	
	private String invoiceNum;
    private String invoiceNumTo;
    private String invoiceNumFrom;
	
	

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		 try {
	            final Object invoiceNumObj = PropertyUtils.getProperty(value, this.invoiceNum);
	            final Object invoiceNumToObj = PropertyUtils.getProperty(value, this.invoiceNumTo);
	            final Object invoiceNumFromObj = PropertyUtils.getProperty(value, this.invoiceNumFrom);
	            
	            if(StringUtils.isEmpty(invoiceNumObj)) {
	            	return true;
	            }
	            else if(StringUtils.isEmpty(invoiceNumToObj)  && StringUtils.isEmpty(invoiceNumFromObj)) {
	            	return true;
	            }
	            
	            else {
	            	return false;
	            }
	             
	          
	        } catch (final Exception ex) {
	        
	            return false;
	        }
		
	
	}

	@Override
	public void initialize(CheckInvoiceNumRangeConstraint invNumRange) {
		this.invoiceNum=invNumRange.invNum();
		this.invoiceNumTo=invNumRange.invNumTo();
		this.invoiceNumFrom=invNumRange.invNumFrom();
		
	}


}
