package org.jzen.invoicing.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckEmailExists.class)

public  @interface CheckEmailExistsConstraint {
	String message() default "{error.emailexists.message}";//use {} for reading validation messages from messages.properties
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
