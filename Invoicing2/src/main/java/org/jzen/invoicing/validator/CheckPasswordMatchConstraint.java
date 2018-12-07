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
@Constraint(validatedBy = CheckPasswordMatchValidator.class)
@Documented
public @interface CheckPasswordMatchConstraint {
	
	String message() ;
	String first();
    String second();
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	  @Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE})
	    @Retention(RetentionPolicy.RUNTIME)
	    @Documented
	    @interface List {
		  CheckPasswordMatchConstraint[] value();
	    }

}
