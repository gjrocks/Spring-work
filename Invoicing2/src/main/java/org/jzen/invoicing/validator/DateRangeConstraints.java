package org.jzen.invoicing.validator;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CurrentInvoicesDateRangeValidator.class)
@Documented
public @interface DateRangeConstraints {
	String message() ;
	String start();
    String end();
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	  @Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE})
	    @Retention(RetentionPolicy.RUNTIME)
	    @Documented
	    @interface List {
		  DateRangeConstraints[] value();
	    }

}
