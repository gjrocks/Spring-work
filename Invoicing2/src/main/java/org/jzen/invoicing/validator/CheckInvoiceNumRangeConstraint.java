package org.jzen.invoicing.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckInvoiceNumRange.class)
@Documented

public @interface CheckInvoiceNumRangeConstraint  {
	String message() ;
	String invNum();
    String invNumTo();
    String invNumFrom();
    
  
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	  @Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE})
	    @Retention(RetentionPolicy.RUNTIME)
	    @Documented
	    @interface List {
		  CheckInvoiceNumRangeConstraint[] value();
	    }

	
	  

}
